package com.slippery.jobposts.service;

import com.slippery.jobposts.model.JobPosting;

import java.util.List;

public interface JobsService {
    JobPosting createNewJobPosting(JobPosting jobPosting);
    JobPosting updateJobPosting(JobPosting jobPosting,Long id);
    void deleteJobPosting(Long id);
    void deleteAllPostings();
    List<JobPosting> getJobByKeyWords(List<String> keywords);
    List<JobPosting> getJobByName(String name);
    List<JobPosting> getJobByLocation(String location);
    List<JobPosting> getAllJobs();
}
