package com.domaji.jwt.member.service;


import com.domaji.jwt.member.dto.MemberDTO;

public interface MemberService {
    Object signup(MemberDTO member);

    Object duplication(String id);

    Object login(MemberDTO member);
}
