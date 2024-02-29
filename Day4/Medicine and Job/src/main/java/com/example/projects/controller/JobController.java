package com.example.projects.controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.projects.model.JobDetails;
import com.example.projects.service.JobService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class JobController 
{
    JobService jobService;
    public JobController(JobService js)
    {
        jobService=js;
    }
    @PostMapping("/job")
    public ResponseEntity<JobDetails> postJobs(@RequestBody JobDetails jobDetails)
    {
        return jobService.postjobDetails(jobDetails);
    }
    
    @GetMapping("/job")
    public ResponseEntity<List<JobDetails>> getMethodName() {
         return jobService.getAllJobDetails();
    }

    @GetMapping("/job/{id}")
    public JobDetails getDetailsById(@PathVariable("id") int id)
    {
        return jobService.getDetailById(id);
    }

    @PutMapping("job/{id}")
    public JobDetails putMethodName(@PathVariable int id, @RequestBody String entity) {
        JobDetails jd=jobService.getDetailById(id);
        return jd;
    }
    
    
}
