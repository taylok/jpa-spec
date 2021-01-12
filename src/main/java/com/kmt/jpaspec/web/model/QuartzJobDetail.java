package com.kmt.jpaspec.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class QuartzJobDetail {
    private String name;
    private String group;
    private String description;
    private Class jobClass;
    private boolean concurrentExectionDisallowed;  // misspelling is actually in Quartz object :)
    private boolean persistJobDataAfterExecution;
    private boolean durable;
    private boolean requestsRecovery;

    private List<QuartzTrigger> triggers;

}
