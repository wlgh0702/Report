package com.domaji.jwt.member.dao;

import com.domaji.jwt.member.dto.AuthorityDTO;
import com.domaji.jwt.member.dto.MemberDTO;
import com.domaji.jwt.member.dto.MemberRoleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {
    Object findMemberId(String memberId);

    int signup(MemberDTO member);

    int duplication(String id);

    MemberDTO findMemberById(String memberId);

    int getSequence();

    void insertAuth(int memberCode, int auth);

    List<MemberRoleDTO> getAuthList(int memberCode);

    AuthorityDTO findAuth(int authorityCode);

    void refreshToken(Map<String, Object> map);

    int check(String accessToken);

    MemberDTO findMemberByMemberId(String username);

    String findToken(String name);
}
