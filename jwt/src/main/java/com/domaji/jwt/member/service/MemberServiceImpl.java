package com.domaji.jwt.member.service;

import com.domaji.jwt.common.ResponseDTO;
import com.domaji.jwt.exception.DuplicatedMemberIdException;
import com.domaji.jwt.jwt.TokenProvider;
import com.domaji.jwt.member.dao.MemberMapper;
import com.domaji.jwt.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            return member;
        }

        return "회원가입 실패!";
    }

    @Override
    public Object duplication(String id) {

        int count = memberMapper.duplication(id);

        return count;
    }

    @Override
    public Object login(MemberDTO member) {

        MemberDTO mem = memberMapper.findMemberById(member.getMemberId());

        ResponseDTO response = new ResponseDTO(HttpStatus.OK, null, null);

        if(mem == null || !passwordEncoder.matches(member.getPassword(), mem.getPassword())) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("로그인 실패");
            response.setData("아이디 또는 비밀번호가 맞지 않습니다.");
        } else if(passwordEncoder.matches(member.getPassword(), mem.getPassword())){
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("로그인 성공");
            response.setData("로그인에 성공하셨습니다.");
        }
        return response;
    }
}
