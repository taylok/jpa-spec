package com.kmt.jpaspec.service;

import com.kmt.jpaspec.domain.Member;
import com.kmt.jpaspec.repository.MemberRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService( @Lazy MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getMembers( ) {
        return memberRepository.findAll();
    }
}
