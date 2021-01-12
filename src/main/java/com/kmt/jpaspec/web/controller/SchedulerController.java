package com.kmt.jpaspec.web.controller;

import com.kmt.jpaspec.service.SchedulerService;
import com.kmt.jpaspec.web.model.QuartzInformation;
import com.kmt.jpaspec.web.model.QuartzJobDetail;
import com.kmt.jpaspec.web.model.QuartzResponse;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/scheduler/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class SchedulerController {
    private SchedulerService schedulerService;

    public SchedulerController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @GetMapping(value = "information")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<QuartzInformation> getSchedulerInformation() {
        try {
            return new ResponseEntity<>(schedulerService.getSchedulerInformation(), HttpStatus.OK);
        } catch (SchedulerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "jobKeys")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<JobKey>> getJobKeys() {
        try {
            return new ResponseEntity<>(schedulerService.getJobKeys(), HttpStatus.OK);
        } catch (SchedulerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "jobDetail")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<QuartzJobDetail> getJobDetail( @RequestParam String name, @RequestParam String group) {
        try {
            return new ResponseEntity<>(schedulerService.getJobDetail(name, group), HttpStatus.OK);
        } catch (SchedulerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "deleteJob")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<QuartzResponse> deleteJob( @RequestParam String name, @RequestParam String group) {
        try {
            return new ResponseEntity<>(schedulerService.deleteJobDetail(name, group), HttpStatus.ACCEPTED);
        } catch (SchedulerException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
