package com.example.onlineexamination.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "leaderboard")
public class Leaderboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    private Double score;

    private Integer rank;

    public Leaderboard() {
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

    public Double getScore() {
        return score;
    }

    public Integer getRank() {
        return rank;
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

    public void setScore(Double score) {
        this.score = score;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}