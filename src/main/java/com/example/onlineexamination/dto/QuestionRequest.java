package com.example.onlineexamination.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class QuestionRequest {

    @NotBlank
    private String questionText;

    @NotBlank
    private String type;

    @NotNull
    @Positive
    private Integer marks;

    @NotNull
    private Double negativeMarks;

    @NotNull
    private Long examId;

    public QuestionRequest() {
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getType() {
        return type;
    }

    public Integer getMarks() {
        return marks;
    }

    public Double getNegativeMarks() {
        return negativeMarks;
    }

    public Long getExamId() {
        return examId;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    public void setNegativeMarks(Double negativeMarks) {
        this.negativeMarks = negativeMarks;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }
}