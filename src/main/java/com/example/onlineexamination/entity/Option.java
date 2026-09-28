package com.example.onlineexamination.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String optionText;

    @Column(nullable = false)
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public Option() {
    }

    public Long getId() {
        return id;
    }

    public String getOptionText() {
        return optionText;
    }

    public boolean isCorrect() {
        return correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}