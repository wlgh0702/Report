package com.domaji.jwt.member.service;

import com.domaji.jwt.member.dao.MemberMapper;
import com.domaji.jwt.member.dto.AuthorityDTO;
import com.domaji.jwt.member.dto.MemberDTO;
import com.domaji.jwt.member.dto.MemberRoleDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final MemberMapper memberMapper;

    public CustomUserDetailService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MemberDTO member = memberMapper.findMemberByMemberId(username);

        List<MemberRoleDTO> memberRoleList = memberMapper.getAuthList(member.getMemberCode());
        System.out.println(memberRoleList);
        for(MemberRoleDTO memberRole : memberRoleList) {
            AuthorityDTO auth = memberMapper.findAuth(memberRole.getAuthorityCode());
            memberRole.setAuthority(auth);
        }
        member.setMemberRole(memberRoleList);

        List<GrantedAuthority> authorities = new ArrayList<>();
        for(MemberRoleDTO memberRole : member.getMemberRole()) {
            String authorityName = memberRole.getAuthority().getAuthorityName();
            authorities.add(new SimpleGrantedAuthority(authorityName));
            member.setAuthorities(authorities);
        }
        return member;
    }
}
