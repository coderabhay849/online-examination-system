package com.example.onlineexamination.controller;

import com.example.onlineexamination.dto.QuestionRequest;
import com.example.onlineexamination.entity.Question;
import com.example.onlineexamination.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructor/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<Question> createQuestion(
            @Valid @RequestBody QuestionRequest request) {
        return ResponseEntity.ok(questionService.createQuestion(request));
    }

    @GetMapping("/exam/{examId}")
    public ResponseEntity<List<Question>> getQuestions(
            @PathVariable Long examId) {
        return ResponseEntity.ok(questionService.getQuestionsByExam(examId));
    }
    
    @GetMapping("/exam/{examId}/random")
    public ResponseEntity<List<Question>> getRandomQuestions(
            @PathVariable Long examId,
            @RequestParam int count) {

        return ResponseEntity.ok(
                questionService.getRandomQuestions(examId, count)
        );
    }
}