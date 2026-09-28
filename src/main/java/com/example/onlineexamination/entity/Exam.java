package com.example.onlineexamination.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer durationMinutes;

    @Column(nullable = false)
    private Integer totalMarks;

    @Column(nullable = false)
    private Double negativeMark;

    @Column(nullable = false)
    private boolean published = false;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public Exam() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public Double getNegativeMark() {
        return negativeMark;
    }

    public boolean isPublished() {
        return published;
    }

    public Course getCourse() {
        return course;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }

    public void setNegativeMark(Double negativeMark) {
        this.negativeMark = negativeMark;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}