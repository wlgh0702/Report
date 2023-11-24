package com.domaji.practice.member.service;

import com.domaji.practice.member.dto.MemberDTO;

import java.util.Map;

public interface MemberService {
    int insertMember(Map member);

    MemberDTO login(Map pwd);

    int duplication(String id);
}
