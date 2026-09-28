package com.example.onlineexamination.controller;

import com.example.onlineexamination.entity.Exam;
import com.example.onlineexamination.repository.ExamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/exams")
public class StudentExamController {

    private final ExamRepository examRepository;

    public StudentExamController(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @GetMapping
    public ResponseEntity<List<Exam>> getAvailableExams() {
        return ResponseEntity.ok(examRepository.findByPublishedTrue());
    }
}