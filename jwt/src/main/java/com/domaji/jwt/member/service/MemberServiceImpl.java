package com.domaji.jwt.member.service;

import com.domaji.jwt.common.ResponseDTO;
import com.domaji.jwt.exception.DuplicatedMemberIdException;
import com.domaji.jwt.jwt.TokenDTO;
import com.domaji.jwt.jwt.TokenProvider;
import com.domaji.jwt.member.dao.MemberMapper;
import com.domaji.jwt.member.dto.AuthorityDTO;
import com.domaji.jwt.member.dto.MemberDTO;
import com.domaji.jwt.member.dto.MemberRoleDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    /* 회원가입 로직 */
    @Override
    @Transactional
    public Object signup(MemberDTO member) {

        if(memberMapper.findMemberId(member.getMemberId()) != null) {
            throw new DuplicatedMemberIdException("중복된 아이디가 있습니다");
        }

        member.setMemberPwd(passwordEncoder.encode(member.getPassword()));

        // result == 1 => 성공
        int result = memberMapper.signup(member);

        if(result == 1) {
            int sequence = memberMapper.getSequence();
            memberMapper.insertAuth(sequence, 1);
            return member;
        }

        return "회원가입 실패!";
    }

    /* 아이디 중복검사 */
    @Override
    public Object duplication(String id) {

        /* count == 0? 중복 X : 중복 O */
        int count = memberMapper.duplication(id);

        return count;
    }

    /* 로그인 시 토큰 발급 */
    @Override
    @Transactional
    public TokenDTO login(MemberDTO member) {

        MemberDTO mem = memberMapper.findMemberById(member.getMemberId());
        TokenDTO token = new TokenDTO();

        if(mem != null && passwordEncoder.matches(member.getPassword(), mem.getPassword())){
            int memberCode = mem.getMemberCode();
            List<MemberRoleDTO> memberRoleList = memberMapper.getAuthList(memberCode);
            System.out.println(memberRoleList);
            for(MemberRoleDTO memberRole : memberRoleList) {
                AuthorityDTO auth = memberMapper.findAuth(memberRole.getAuthorityCode());
                memberRole.setAuthority(auth);
            }
            member.setMemberRole(memberRoleList);

            token = tokenProvider.generateTokenDTO(member);
            Map<String, Object> map = new HashMap<>();
            map.put("refreshToken", token.getRefreshToken());
            map.put("memberCode", memberCode);
            memberMapper.refreshToken(map);
            token.setMemberCode(mem.getMemberCode());
        }

        System.out.println(token);
        return token;
    }

    @Override
    public Object check(String token) {

        /* 토큰의 유효성 검사 (만료되면 false 를 반환) */
        boolean validation = tokenProvider.validateToken(token);

        if(validation == true) {
            return true;
        } else {
            Claims auth = tokenProvider.getAuth(token);
            String refreshToken = memberMapper.findToken(auth.getSubject());
            /* 리프레시 토큰의 만료상태 검사 (만료 시 false반환) */
            boolean refresh = tokenProvider.validateToken(refreshToken);
            if(refresh == true) {
                String accessToken = tokenProvider.accessToken(refreshToken);
                return accessToken;
            }
        }
        return false;
    }

}
