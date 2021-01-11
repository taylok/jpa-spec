package com.kmt.jpaspec.repository;

import com.kmt.jpaspec.domain.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class, Long> {
    List<Class> findAllByNameContainsIgnoreCase(String searchString);
}
