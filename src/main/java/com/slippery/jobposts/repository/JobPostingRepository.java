package com.slippery.jobposts.repository;

import com.slippery.jobposts.model.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingRepository extends JpaRepository<JobPosting,Long> {
}
