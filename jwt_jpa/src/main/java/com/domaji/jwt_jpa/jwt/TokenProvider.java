package com.domaji.jwt_jpa.jwt;

import com.domaji.jwt_jpa.exception.TokenException;
import com.domaji.jwt_jpa.member.entity.Member;
import com.domaji.jwt_jpa.member.entity.MemberRole;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TokenProvider {

    private static final String AUTHORITIES_KEY = "auth";
    private static final String BEARER_TYPE = "Bearer";
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 30;
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 14;
    private final Key key;
    private final UserDetailsService userDetailsService;

    public TokenProvider(@Value("${jwt.secret}") String secretKey, UserDetailsService userDetailsService) {
        byte[] keyBytest = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytest);
        this.userDetailsService = userDetailsService;
    }

    /* access, refresh token 둘 다 생성 */
    public TokenDTO generateToken(Member member) {

        List<String> roles = new ArrayList<>();
        for(MemberRole memberRole : member.getMemberRole()) {
            roles.add(memberRole.getAuthority().getAuthorityName());
        }

        Claims claims = Jwts.claims().setSubject(member.getMemberId());
        claims.put(AUTHORITIES_KEY, roles);

        long now = System.currentTimeMillis();
        Date accessTokenExpiresIn = new Date(now + ACCESS_TOKEN_EXPIRE_TIME);
        Date refreshTokenExpiresIn = new Date(now + REFRESH_TOKEN_EXPIRE_TIME);

        String accessToken = Jwts.builder()
                .setClaims(claims)
                .setExpiration(accessTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
        String refreshToken = Jwts.builder()
                .setClaims(claims)
                .setExpiration(refreshTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();

        return new TokenDTO(BEARER_TYPE, member.getMemberName(), accessToken, refreshToken, accessTokenExpiresIn.getTime());
    }

    /* 토큰으로 회원 아이디 추출 */
    public String getUserId(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key).build()
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    /* accessToken으로 인증 객체 추출 */
    public Authentication getAuthentication(String token) {
        Claims claims = parseClaims(token);

        if(claims.get(AUTHORITIES_KEY) == null) {
            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserId(token));

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public boolean validateToken(String token){

        try{
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        }catch(io.jsonwebtoken.security.SecurityException | MalformedJwtException e){
            throw new TokenException("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e){
            throw new TokenException("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e){
            throw new TokenException("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e){
            throw new TokenException("JWT 토큰이 잘못되었습니다.");
        }
    }

    private Claims parseClaims(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }


}
