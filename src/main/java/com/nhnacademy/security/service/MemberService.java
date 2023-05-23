package com.nhnacademy.security.service;

import com.nhnacademy.security.domain.LoginForm;
import com.nhnacademy.security.entity.Member;
import com.nhnacademy.security.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    @Transactional
    public Member doLogin(LoginForm loginForm){
        Member member = repository.findById(loginForm.getId()).get();
        if(Objects.isNull(member)){
            throw new RuntimeException();
        }
        return member;
    }
}
