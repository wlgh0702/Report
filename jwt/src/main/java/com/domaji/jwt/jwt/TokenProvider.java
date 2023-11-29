package com.domaji.jwt.jwt;

import com.domaji.jwt.exception.TokenException;
import com.domaji.jwt.member.dto.MemberDTO;
import com.domaji.jwt.member.dto.MemberRoleDTO;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;

/* 토큰 생성, 토큰 인증(Authenication 객체 반환), 토큰 유효성 검사 */
@Component
public class TokenProvider {

    private static final String AUTHORITIES_KEY = "auth";
    private static final String BEARER_TYPE = "Bearer";     // Bearer 토큰 사용시 앞에 붙이는 prefix 문자열
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 60;    // 1시간(ms단위)
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 15; // 15일
    private final Key key;
    private final UserDetailsService userDetailsService;

    public TokenProvider(@Value("${jwt.secret}") String secretKey, UserDetailsService userDetailsService) {

        byte[] keyBytest = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytest);
        this.userDetailsService = userDetailsService;
    }

    /* 1. 토큰 생성 메소드 */
    public TokenDTO generateTokenDTO(MemberDTO member) {
        List<String> roles = new ArrayList<>();
        for(MemberRoleDTO memberRole : member.getMemberRole()) {
            roles.add(memberRole.getAuthority().getAuthorityName());
        }

        /* 1. 회원 아이디를 "sub"라는 클레임으로 토큰에 추가 */
        Claims claims = Jwts.claims().setSubject(member.getMemberId());
        claims.put("memberCode", member.getMemberCode());

        /* 2. 회원의 권한들을 "auth"라는 클레임으로 토큰에 추가 */
        claims.put(AUTHORITIES_KEY, roles);

        long now = System.currentTimeMillis();      // 현재 시각을 ms 단위로 가져옴

        Date accessTokenExpiresIn = new Date(now + ACCESS_TOKEN_EXPIRE_TIME);
        Date refreshTokenExpiresIn = new Date(now + REFRESH_TOKEN_EXPIRE_TIME);
        String accessToken = Jwts.builder()
                .setClaims(claims)
                .setExpiration(accessTokenExpiresIn)    // 토큰의 만료기간을 DATE형으로 토큰에 추가
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();

        String refreshToken = Jwts.builder()
                .setClaims(claims)
                .setExpiration(refreshTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();

        return new TokenDTO(BEARER_TYPE, member.getMemberName(), accessToken, refreshToken, accessTokenExpiresIn.getTime());
    }

    /* 2. 토큰의 등록된 클레임의 subject에서 해당 회원의 아이디를 추출 */
    public String getMemberId(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key).build()
                .parseClaimsJws(token)
                .getBody()          // payload의 Claims 추출
                .getSubject();      // Claim 중에 등록 클레임에 해당하는 sub값 추출(회원 아이디)
    }

    /* 3. AccessToken으로 인증 객체 추출 */
    public Authentication getAuthentication(String token) {

        Claims claims = parseClaims(token);

        if(claims.get(AUTHORITIES_KEY) == null) {
            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getMemberId(token));

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    /* 4. 토큰 유효성 검사 */
    public Boolean validateToken(String token) {

        try{
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            throw new TokenException("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            throw new TokenException("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            throw new TokenException("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            throw new TokenException("JWT 토큰이 잘못되었습니다.");
        }
    }

    /* 5. AccessToken에서 클레임 추출하는 메소드 */
    private Claims parseClaims(String token) {
        try{
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();   // 토큰이 만료되어 예외가 발생하더라도 클레임 값을 뽑을 수 있다.
        }
    }
}
