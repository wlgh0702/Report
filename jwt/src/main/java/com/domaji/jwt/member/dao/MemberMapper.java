package com.domaji.jwt.member.dao;

import com.domaji.jwt.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Object findMemberId(String memberId);

    int signup(MemberDTO member);

    int duplication(String id);

    MemberDTO findMemberById(String memberId);
}
