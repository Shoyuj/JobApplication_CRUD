package com.jobApplication.Job_filter;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    private final JobRepository jobRepository;

    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @GetMapping
    public List<JobApplication> getJobs(){
        return jobRepository.findAll();
    }

    @GetMapping("/filter")
    public List<JobApplication> getJobsByStatus(@RequestParam String status) {
        return jobRepository.findByStatus(status);
    }

    record newJob(Integer id, String companyName, String role, String dateApplied, String status){}

    @PostMapping
    public void addJob(@RequestBody newJob response)
    {
        JobApplication jobApplication = new JobApplication();
        jobApplication.setId(response.id);
        jobApplication.setCompanyName(response.companyName);
        jobApplication.setRole(response.role);
        jobApplication.setDateApplied(response.dateApplied);
        jobApplication.setStatus(response.status);
        jobRepository.save(jobApplication);
    }

    @DeleteMapping("{jobid}")
    public void deleteJob(@PathVariable("jobid") Integer id){
        jobRepository.deleteById(id);
    }

    @PutMapping("/update/{job_id}")
    public void updateJob(@PathVariable("job_id") Integer id,@RequestBody newJob response)
    {
        JobApplication jobApplication= jobRepository.findById(id).orElseThrow();
        jobApplication.setCompanyName(response.companyName);
        jobApplication.setRole(response.role);
        jobApplication.setDateApplied(response.dateApplied);
        jobApplication.setStatus(response.status);
        jobRepository.save(jobApplication);
    }
}
