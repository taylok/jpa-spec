package com.kmt.jpaspec.web.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FilterRequest {
    private Boolean active;
    private String zipFilter;
}
