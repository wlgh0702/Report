package com.domaji.practice.member.controller;

import com.domaji.practice.member.dto.MemberDTO;
import com.domaji.practice.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 들어오면 바로 로그인 페이지로
    @GetMapping("/")
    public String login() {
        return "login";
    }

    // 로그아웃 눌렀을 때
    @GetMapping("/login")
    public String login1() {
        return "login";
    }

    // 회원가입 클릭 시 회원가입 페이지로
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    // 회원가입 PostMapping
    @PostMapping("/signup")
    public String signup(String id, String pwd, String name, String birth, String email) {

        Map member = new HashMap();
        member.put("id", id);
        member.put("pwd", pwd);
        member.put("name", name);
        member.put("birth", birth);
        member.put("email", email);

        int result = memberService.insertMember(member);

        System.out.println(result);

        return result == 1? "login" : null;
    }

    // 로그인 PostMapping
    @PostMapping("/login")
    public String login(String id, String pwd, HttpServletRequest request) {

        Map login = new HashMap();
        login.put("id", id);
        login.put("pwd", pwd);

        MemberDTO member = memberService.login(login);

        if(member != null) {
            HttpSession session = request.getSession();
            session.setAttribute("member", member);
        }

        return member != null? "redirect:/board" : "redirect:/";
    }

    @PostMapping("/duplication")
    @ResponseBody
    public int duplication(String id) {

        System.out.println(id);
        int result = memberService.duplication(id);

        return result;
    }
}
