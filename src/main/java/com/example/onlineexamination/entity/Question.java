package com.example.onlineexamination.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String questionText;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Integer marks;

    @Column(nullable = false)
    private Double negativeMarks;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    public Question() {
    }

    public Long getId() {
        return id;
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

    public Exam getExam() {
        return exam;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}