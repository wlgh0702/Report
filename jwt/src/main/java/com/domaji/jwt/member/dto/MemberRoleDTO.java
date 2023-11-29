package com.domaji.jwt.member.dto;

import lombok.*;

@Setter
@Getter
@ToString
public class MemberRoleDTO {

    private String memberCode;
    private String authorityCode;
    private AuthorityDTO authority;

    public MemberRoleDTO() {
    }

    public MemberRoleDTO(String memberCode, String authorityCode) {
        this.memberCode = memberCode;
        this.authorityCode = authorityCode;
    }

    public MemberRoleDTO(String memberCode, String authorityCode, AuthorityDTO authority) {
        this.memberCode = memberCode;
        this.authorityCode = authorityCode;
        this.authority = authority;
    }
}
