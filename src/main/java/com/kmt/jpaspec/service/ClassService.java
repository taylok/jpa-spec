package com.kmt.jpaspec.service;

import com.kmt.jpaspec.domain.Member;
import com.kmt.jpaspec.domain.Class;
import com.kmt.jpaspec.repository.ClassRepository;
import com.kmt.jpaspec.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ClassService {
    private ClassRepository classRepository;
    private MemberRepository memberRepository;

    public ClassService(ClassRepository classRepository, MemberRepository memberRepository) {
        this.classRepository = classRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional(propagation= Propagation.REQUIRED, readOnly=true)
    public void classStats() {
        List<Class> classes = classRepository.findAll();

        Map<String, Integer> classesMap = classes
                .stream()
                .collect(Collectors.toMap(Class::getName, c -> 0));

        List<Member> members = memberRepository.findAll();

        for (Member member : members) {
            if (CollectionUtils.isNotEmpty(member.getClasses())) {
                for (Class memberClass : member.getClasses()) {
                    // Another way to do this ...
                    // classesMap.computeIfPresent(memberClass.getName(), (k, v) -> v + 1);
                    classesMap.merge(memberClass.getName(), 1, Integer::sum);
                }
            }
        }

        log.info("Class Statics:");
        log.info("=============");
        classesMap.forEach((k,v) -> log.info("{}: {}", k, v));
        log.info("==========================");
    }

}
