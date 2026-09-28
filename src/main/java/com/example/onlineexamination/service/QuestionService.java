package com.example.onlineexamination.service;

import com.example.onlineexamination.dto.QuestionRequest;
import com.example.onlineexamination.entity.Question;

import java.util.List;

public interface QuestionService {

    Question createQuestion(QuestionRequest request);

    List<Question> getQuestionsByExam(Long examId);

    List<Question> getRandomQuestions(Long examId, int count);
}