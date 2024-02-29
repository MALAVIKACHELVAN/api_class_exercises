package com.example.projects.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class JobDetails {
    @Id
    private int jobid;
    private String jobTitle;
    private int minSalary;
    private String jobDescription;
    private int maxSalary;
    public JobDetails()
    {
        
    }
    public int getJobid() {
        return jobid;
    }
    public void setJobid(int jobid) {
        this.jobid = jobid;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public int getMinSalary() {
        return minSalary;
    }
    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }
    public String getJobDescription() {
        return jobDescription;
    }
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    public int getMaxSalary() {
        return maxSalary;
    }
    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }
    public JobDetails(int jobid, String jobTitle, int minSalary, String jobDescription, int maxSalary) {
        this.jobid = jobid;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.jobDescription = jobDescription;
        this.maxSalary = maxSalary;
    }

    
}
