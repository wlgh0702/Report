package com.domaji.jwt.member.service;


import com.domaji.jwt.jwt.TokenDTO;
import com.domaji.jwt.member.dto.MemberDTO;

public interface MemberService {
    Object signup(MemberDTO member);

    Object duplication(String id);

    TokenDTO login(MemberDTO member);

    Object check(String accessToken);
}
