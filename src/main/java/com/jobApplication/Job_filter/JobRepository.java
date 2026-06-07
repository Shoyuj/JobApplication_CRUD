package com.jobApplication.Job_filter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<JobApplication, Integer> {

    List<JobApplication> findByStatus(String status);
}
