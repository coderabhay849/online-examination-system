package com.example.onlineexamination.service;

import com.example.onlineexamination.dto.ExamRequest;
import com.example.onlineexamination.entity.Exam;

import java.util.List;

public interface ExamService {

    Exam createExam(ExamRequest request);

    Exam updateExam(Long id, ExamRequest request);

    Exam getExamById(Long id);

    List<Exam> getAllExams();

    String publishExam(Long id);
}