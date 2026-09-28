package com.example.onlineexamination.dto;

import jakarta.validation.constraints.NotBlank;

public class CourseRequest {

    @NotBlank(message = "Course name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    public CourseRequest() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}