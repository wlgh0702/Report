package com.domaji.jwt.member.controller;

import com.domaji.jwt.common.ResponseDTO;
import com.domaji.jwt.jwt.TokenDTO;
import com.domaji.jwt.member.dto.MemberDTO;
import com.domaji.jwt.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /* 회원가입 */
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@ModelAttribute MemberDTO member) {

        System.out.println(member);

        return ResponseEntity
                .ok()
                .body(new ResponseDTO(HttpStatus.CREATED, "회원가입 성공", memberService.signup(member)));
    }

    @GetMapping("/duplication/{id}")
    public ResponseEntity<?> duplication(@PathVariable String id) {

        return ResponseEntity
                .ok()
                .body(new ResponseDTO(HttpStatus.OK, "조회 성공", memberService.duplication(id)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@ModelAttribute MemberDTO member) {

        TokenDTO token = memberService.login(member);

        if(token.getAccessToken() != null) {
            return ResponseEntity
                    .ok()
                    .body(new ResponseDTO(HttpStatus.OK, "로그인", memberService.login(member)));
        }

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, "로그인 실패", null));
    }

    @PostMapping("/tokenCheck")
    public ResponseEntity<?> tokenCheck(@RequestBody String token) {

        return ResponseEntity
                .ok().body(new ResponseDTO(HttpStatus.OK, "토큰 조회", memberService.check(token)));
    }

}
