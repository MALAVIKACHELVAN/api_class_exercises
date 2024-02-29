package com.example.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projects.model.JobDetails;

public interface JobRepo extends JpaRepository<JobDetails,Integer> {
    
}
