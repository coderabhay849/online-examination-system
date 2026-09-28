package com.example.onlineexamination.service.serviceimpl;

import com.example.onlineexamination.dto.QuestionRequest;
import com.example.onlineexamination.entity.Exam;
import com.example.onlineexamination.entity.Question;
import com.example.onlineexamination.repository.ExamRepository;
import com.example.onlineexamination.repository.QuestionRepository;
import com.example.onlineexamination.service.QuestionService;
import org.springframework.stereotype.Service;
import java.util.Collections;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final ExamRepository examRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository,
                               ExamRepository examRepository) {
        this.questionRepository = questionRepository;
        this.examRepository = examRepository;
    }

    @Override
    public Question createQuestion(QuestionRequest request) {

        Exam exam = examRepository.findById(request.getExamId())
                .orElseThrow(() -> new RuntimeException("Exam not found"));

        Question question = new Question();
        question.setQuestionText(request.getQuestionText());
        question.setType(request.getType());
        question.setMarks(request.getMarks());
        question.setNegativeMarks(request.getNegativeMarks());
        question.setExam(exam);

        return questionRepository.save(question);
    }

    @Override
    public List<Question> getQuestionsByExam(Long examId) {
        return questionRepository.findAll()
                .stream()
                .filter(q -> q.getExam().getId().equals(examId))
                .toList();
    }
    
    @Override
    public List<Question> getRandomQuestions(Long examId, int count) {

        List<Question> questions = questionRepository.findAll()
                .stream()
                .filter(q -> q.getExam().getId().equals(examId))
                .toList();

        Collections.shuffle(questions);

        if (count >= questions.size()) {
            return questions;
        }

        return questions.subList(0, count);
    }
}