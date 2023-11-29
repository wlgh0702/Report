package com.domaji.jwt.member.controller;

import com.domaji.jwt.member.dto.MemberDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody MemberDTO member) {



        return ResponseEntity.ok().body("!");
    }
}
