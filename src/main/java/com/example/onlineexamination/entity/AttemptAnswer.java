package com.example.onlineexamination.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "attempt_answers")
public class AttemptAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "attempt_id", nullable = false)
    private StudentAttempt attempt;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    private Long selectedOptionId;

    public AttemptAnswer() {
    }

    public Long getId() {
        return id;
    }

    public StudentAttempt getAttempt() {
        return attempt;
    }

    public Question getQuestion() {
        return question;
    }

    public Long getSelectedOptionId() {
        return selectedOptionId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAttempt(StudentAttempt attempt) {
        this.attempt = attempt;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setSelectedOptionId(Long selectedOptionId) {
        this.selectedOptionId = selectedOptionId;
    }
}