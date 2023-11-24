package com.domaji.practice.member.dao;

import com.domaji.practice.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface MemberMapper {
    public int insertMember(Map member);

    MemberDTO getMember(Object id);

    int duplication(String id);
}
