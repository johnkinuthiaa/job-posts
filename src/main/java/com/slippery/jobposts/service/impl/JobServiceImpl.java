package com.slippery.jobposts.service.impl;

import com.slippery.jobposts.model.JobPosting;
import com.slippery.jobposts.repository.JobPostingRepository;
import com.slippery.jobposts.service.JobsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobsService {
    private final JobPostingRepository repository;

    public JobServiceImpl(JobPostingRepository repository) {
        this.repository = repository;
    }

    @Override
    public JobPosting createNewJobPosting(JobPosting jobPosting) {
        return null;
    }

    @Override
    public JobPosting updateJobPosting(JobPosting jobPosting) {
        return null;
    }

    @Override
    public JobPosting deleteJobPosting(Long id) {
        return null;
    }

    @Override
    public void deleteAllPostings() {

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
        return List.of();
    }
}
