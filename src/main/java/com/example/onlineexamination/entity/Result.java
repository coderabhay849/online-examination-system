package com.example.onlineexamination.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "attempt_id", nullable = false)
    private StudentAttempt attempt;

    private Double score;

    private Integer totalMarks;

    private Double percentage;

    private boolean passed;
    
    private boolean published = false;
    
    public boolean isPublished() {
        return published;
    }
    
    public void setPublished(boolean published) {
        this.published = published;
    }
    

    public Result() {
    }

    public Long getId() {
        return id;
    }

    public StudentAttempt getAttempt() {
        return attempt;
    }

    public Double getScore() {
        return score;
    }

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public Double getPercentage() {
        return percentage;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAttempt(StudentAttempt attempt) {
        this.attempt = attempt;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}