package com.nhnacademy.security.controller;

import com.nhnacademy.security.domain.LoginForm;
import com.nhnacademy.security.entity.Member;
import com.nhnacademy.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final MemberService service;
    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/")
    public String doLogin(LoginForm loginForm, HttpSession session){
        Member member = service.doLogin(loginForm);
        session.setAttribute("member",member);
        return "afterlogin";
    }
}
