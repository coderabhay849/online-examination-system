package com.example.onlineexamination.controller;

import com.example.onlineexamination.dto.ExamRequest;
import com.example.onlineexamination.entity.Exam;
import com.example.onlineexamination.service.ExamService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructor/exams")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping
    public ResponseEntity<Exam> createExam(
            @Valid @RequestBody ExamRequest request) {

        return ResponseEntity.ok(
                examService.createExam(request)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exam> updateExam(
            @PathVariable Long id,
            @Valid @RequestBody ExamRequest request) {

        return ResponseEntity.ok(
                examService.updateExam(id, request)
        );
    }

    @GetMapping
    public ResponseEntity<List<Exam>> getAllExams() {

        return ResponseEntity.ok(
                examService.getAllExams()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exam> getExamById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                examService.getExamById(id)
        );
    }

    @PutMapping("/{id}/publish")
    public ResponseEntity<String> publishExam(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                examService.publishExam(id)
        );
    }
}