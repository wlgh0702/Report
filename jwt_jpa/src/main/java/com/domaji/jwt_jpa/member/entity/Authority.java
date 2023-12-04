package com.domaji.jwt_jpa.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "TBL_MEM_AUTH")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberRole {

    @Id
    @Column(name = "AUTHORITY_CODE")
    private int authorityCode;

    @Column(name = "AUTHORITY_NAME")
    private String authorityName;

    @Column(name = "AUTHORITY_DESC")
    private String authorityDesc;
}
