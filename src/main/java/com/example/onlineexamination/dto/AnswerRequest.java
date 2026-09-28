package com.example.onlineexamination.dto;

public class AnswerRequest {

    private Long questionId;
    private Long selectedOptionId;

    public AnswerRequest() {
    }

    public Long getQuestionId() {
        return questionId;
    }

    public Long getSelectedOptionId() {
        return selectedOptionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setSelectedOptionId(Long selectedOptionId) {
        this.selectedOptionId = selectedOptionId;
    }
}