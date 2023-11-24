package com.domaji.practice.member.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {

    private int memberNo;
    private String id;
    private String pwd;
    private String name;
    private String birth;
    private String email;

    public MemberDTO(String id, String pwd, String name, String birth, String email) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.birth = birth;
        this.email = email;
    }
}
