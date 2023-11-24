package com.domaji.practice.member.service;

import com.domaji.practice.member.dao.MemberMapper;
import com.domaji.practice.member.dto.MemberDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    public MemberServiceImpl(MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public int insertMember(Map member) {

        String modifyPwd = passwordEncoder.encode(member.get("pwd").toString());

        System.out.println(modifyPwd);

        member.replace("pwd", modifyPwd);

        System.out.println(member);

        int result = memberMapper.insertMember(member);

        return result == 0? 0 : 1;
    }

    @Override
    public MemberDTO login(Map login) {

        MemberDTO member = memberMapper.getMember(login.get("id"));

        int result = 0;

        if(passwordEncoder.matches(login.get("pwd").toString(), member.getPwd())) {
            result = 1;
        }

        System.out.println(member);

        return result == 1? member : null;
    }

    @Override
    public int duplication(String id) {

        int result = memberMapper.duplication(id);

        return result == 0? 1 : 0;
    }
}