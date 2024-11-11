package com.slippery.jobposts.controller;

import com.slippery.jobposts.model.JobPosting;
import com.slippery.jobposts.service.JobsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/job-postings")
public class JobPostingController {
    private final JobsService service;
    public  JobPostingController(JobsService service){
        this.service=service;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<JobPosting>> getAllJobs(){
        return ResponseEntity.ok(service.getAllJobs());
    }
    @GetMapping("/get/by-keywords")
    public ResponseEntity<List<JobPosting>> getJobByKeyWords(@RequestParam List<String> keywords){
        return ResponseEntity.ok(service.getJobByKeyWords(keywords));
    }
    @GetMapping("/get/location")
    public ResponseEntity<List<JobPosting>> getJobByLocation(@RequestParam String location){
        return ResponseEntity.ok(service.getJobByLocation(location));
    }
    @GetMapping("/get/job-name")
    public ResponseEntity<List<JobPosting>> getJobByName(@RequestParam String name){
        return ResponseEntity.ok(service.getJobByName(name));
    }
    @PostMapping("/create/job-posting")
    public ResponseEntity<JobPosting> createNewJobPosting(@RequestBody JobPosting jobPosting){
        return ResponseEntity.ok(service.createNewJobPosting(jobPosting));
    }
    @PutMapping("/update/job-posting/id")
    public ResponseEntity<JobPosting> updateJobPosting(@RequestBody JobPosting jobPosting,@RequestParam Long id){
        return ResponseEntity.ok(service.updateJobPosting(jobPosting, id));
    }
    @DeleteMapping("/delete/id")
    public void deleteJobPosting(@RequestParam Long id){
        service.deleteJobPosting(id);
    }
    @DeleteMapping("/delete/all-postings")
    public void deleteAllPostings(){
        service.deleteAllPostings();
    }

//
}
