package com.example.projects.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.projects.model.JobDetails;
import com.example.projects.repository.JobRepo;

@Service
public class JobService {
    JobRepo jobRepo;
    public JobService(JobRepo j)
    {
        jobRepo=j;
    }

    public ResponseEntity<JobDetails> postjobDetails(JobDetails jobDetails)
    {
       if(jobDetails==null)
       {
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
       }
       else{
          jobRepo.save(jobDetails);
          return new ResponseEntity<>(jobDetails,HttpStatus.CREATED);
       }
    }
    public ResponseEntity<List<JobDetails>> getAllJobDetails()
    {
         List<JobDetails>list=jobRepo.findAll();
         if(list.isEmpty())
         {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
         }
         else{
            return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
         }
    }
    public JobDetails getDetailById(int id)
    {
      return jobRepo.findById(id).orElse(null);

    //    if(details==null)
    //    {
    //       return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
    //    }
    //    else{
    //     return new ResponseEntity<>(details,HttpStatus.ACCEPTED);
    //    }
    }

}
