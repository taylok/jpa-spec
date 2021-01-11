package com.kmt.jpaspec.repository;

import com.kmt.jpaspec.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
