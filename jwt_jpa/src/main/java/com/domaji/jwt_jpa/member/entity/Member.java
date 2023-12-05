package com.domaji.jwt_jpa.member.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "TBL_MEMBER")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Member {

    @Id
    @Column(name = "MEMBER_CODE")
    private int memberCode;

    @Column(name = "MEMBER_ID")
    private String memberId;

    @Column(name = "MEMBER_PWD")
    private String memberPwd;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @OneToMany
    @JoinColumn(name = "MEMBER_CODE")
    private List<MemberRole> memberRole;

    @Override
    public String toString() {
        return "Member{" +
                "memberCode=" + memberCode +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberRole=" + memberRole +
                '}';
    }
}
