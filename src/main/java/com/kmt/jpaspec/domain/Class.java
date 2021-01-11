package com.kmt.jpaspec.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class Class {
    @Id
    @GeneratedValue
    private long id;
    private String name;

}
