package com.domaji.jwt_jpa.member.entity;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MemberRolePK implements Serializable {

    private int memberCode;
    private int authorityCode;
}
