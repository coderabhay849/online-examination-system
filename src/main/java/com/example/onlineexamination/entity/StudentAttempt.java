package com.example.onlineexamination.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "student_attempts")
public class StudentAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private boolean submitted = false;

    private Integer attemptNumber;

    private Double score = 0.0;

    public StudentAttempt() {
    }

    public Long getId() {
        return id;
    }

    public Exam getExam() {
        return exam;
    }

    public User getStudent() {
        return student;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public Integer getAttemptNumber() {
        return attemptNumber;
    }

    public Double getScore() {
        return score;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public void setAttemptNumber(Integer attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}