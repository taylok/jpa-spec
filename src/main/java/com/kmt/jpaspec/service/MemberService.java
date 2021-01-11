package com.kmt.jpaspec.service;

import com.kmt.jpaspec.domain.Member;
import com.kmt.jpaspec.repository.MemberRepository;
import com.kmt.jpaspec.specification.MemberSpecification;
import com.kmt.jpaspec.web.model.FilterRequest;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private MemberRepository memberRepository;
    private MemberSpecification memberSpecification;

    public MemberService( @Lazy MemberRepository memberRepository, @Lazy MemberSpecification memberSpecification) {
        this.memberRepository = memberRepository;
        this.memberSpecification = memberSpecification;
    }

    public List<Member> getMembers( FilterRequest filter ) {
            return memberRepository.findAll(Specification.where(memberSpecification.getFilter(filter)));
    }
}



