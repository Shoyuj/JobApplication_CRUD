package com.jobApplication.Job_filter;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class JobApplication {

    JobApplication(){}

    public JobApplication(Integer id, String companyName, String role, String dateApplied, String status) {
        this.id = id;
        this.companyName = companyName;
        this.role = role;
        this.dateApplied = dateApplied;
        this.status = status;
    }

    @Id
    @SequenceGenerator(
            name = "job_application_id",
            sequenceName = "job_application_id"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "job_application_id"
    )

    private Integer id;
    private String companyName;
    private String role;
    private String dateApplied;
    private String status;

    @Override
    public String toString() {
        return "JobApplication{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", role='" + role + '\'' +
                ", dateApplied='" + dateApplied + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        JobApplication that = (JobApplication) o;
        return Objects.equals(id, that.id) && Objects.equals(companyName, that.companyName) && Objects.equals(role, that.role) && Objects.equals(dateApplied, that.dateApplied) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, role, dateApplied, status);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(String dateApplied) {
        this.dateApplied = dateApplied;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
