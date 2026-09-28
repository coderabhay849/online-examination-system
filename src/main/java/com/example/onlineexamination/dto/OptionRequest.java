package com.example.onlineexamination.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OptionRequest {

    @NotBlank
    private String optionText;

    @NotNull
    private Boolean correct;

    @NotNull
    private Long questionId;

    public OptionRequest() {
    }

    public String getOptionText() {
        return optionText;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}