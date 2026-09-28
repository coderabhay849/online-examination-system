package com.example.onlineexamination.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ExamRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Duration is required")
    @Positive(message = "Duration must be positive")
    private Integer durationMinutes;

    @NotNull(message = "Total marks is required")
    @Positive(message = "Total marks must be positive")
    private Integer totalMarks;

    @NotNull(message = "Negative mark is required")
    private Double negativeMark;

    @NotNull(message = "Course id is required")
    private Long courseId;

    public ExamRequest() {
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

    public Long getCourseId() {
        return courseId;
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

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}