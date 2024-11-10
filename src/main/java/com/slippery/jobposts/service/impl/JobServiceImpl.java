package com.slippery.jobposts.service.impl;

import com.slippery.jobposts.model.JobPosting;
import com.slippery.jobposts.repository.JobPostingRepository;
import com.slippery.jobposts.service.JobsService;
import jakarta.persistence.Transient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobsService {
    private final JobPostingRepository repository;

    public JobServiceImpl(JobPostingRepository repository) {
        this.repository = repository;
    }

    @Override
    public JobPosting createNewJobPosting(JobPosting jobPosting) {
        jobPosting.setTimePosted(LocalDateTime.now());

        return repository.save(jobPosting);
    }

    @Override
    public JobPosting updateJobPosting(JobPosting jobPosting,Long id) {
        Optional<JobPosting> currentJob =repository.findById(id);

        if(currentJob.isEmpty()){
            throw new RuntimeException("job does not exist");
        }
        JobPosting job =currentJob.get();
        job.setName(jobPosting.getName());
        job.setPostDesc(jobPosting.getPostDesc());
        job.setPostProfile(jobPosting.getPostProfile());
        job.setLocation(jobPosting.getLocation());
        job.setPostTechStack(jobPosting.getPostTechStack());
        job.setTimePosted(LocalDateTime.now());
        job.setReqExperience(jobPosting.getReqExperience());

        return repository.save(job);
    }

    @Override
    public void deleteJobPosting(Long id) {
        Optional<JobPosting> job =repository.findById(id);
        if(job.isEmpty()){
            throw new RuntimeException("job with id "+id+" does not exist");
        }
        repository.deleteById(id);
    }

    @Override
    public void deleteAllPostings() {
        repository.deleteAll();
    }

    @Override
    public List<JobPosting> getJobByKeyWords(List<String> keywords) {
        List<JobPosting> postings =new ArrayList<>();
        for(String word: keywords){
            var job =repository.findAll().stream()
                    .filter(jobPosting -> jobPosting.getPostDesc().toLowerCase().contains(word.toLowerCase()))
                    .collect(Collectors.toList());
            postings.add((JobPosting) job);
        }
        return postings;
    }

    @Override
    public List<JobPosting> getJobByName(String name) {
        return repository.findAll().stream()
                .filter(jobPosting -> jobPosting.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<JobPosting> getJobByLocation(String location) {
        return repository.findAll().stream()
                .filter(jobPosting -> jobPosting.getLocation().toLowerCase().contains(location.toLowerCase()))
                .collect(Collectors.toList());
    }
}
