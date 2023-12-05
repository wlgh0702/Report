package com.domaji.jwt_jpa.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;

@Entity
@Table(name = "TBL_MEMBER_ROLE")
@Setter
@Getter
@ToString
public class MemberRole {

    @Id
    @Column(name = "MEMBER_CODE")
    private int memberCode;

    @Id
    @Column(name = "AUTHORITY_CODE")
    private int authorityCode;

    @ManyToOne
    @JoinColumn(name = "AUTHORITY_CODE", insertable = false, updatable = false)
    private Authority authority;

    public MemberRole() {
    }

    public MemberRole(int memberCode, int authorityCode) {
        this.memberCode = memberCode;
        this.authorityCode = authorityCode;
    }

    public MemberRole(int memberCode, int authorityCode, Authority authority) {
        this.memberCode = memberCode;
        this.authorityCode = authorityCode;
        this.authority = authority;
    }
}
