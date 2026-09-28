package com.example.onlineexamination.service;

import com.example.onlineexamination.entity.Exam;
import com.example.onlineexamination.entity.StudentAttempt;
import com.example.onlineexamination.entity.User;
import com.example.onlineexamination.repository.AttemptAnswerRepository;
import com.example.onlineexamination.repository.ExamRepository;
import com.example.onlineexamination.repository.OptionRepository;
import com.example.onlineexamination.repository.QuestionRepository;
import com.example.onlineexamination.repository.ResultRepository;
import com.example.onlineexamination.repository.StudentAttemptRepository;
import com.example.onlineexamination.repository.UserRepository;
import com.example.onlineexamination.service.serviceimpl.AttemptServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AttemptServiceImplTest {

    @Mock
    private StudentAttemptRepository attemptRepository;

    @Mock
    private ExamRepository examRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private OptionRepository optionRepository;

    @Mock
    private ResultRepository resultRepository;

    @InjectMocks
    private AttemptServiceImpl attemptService;

    @Test
    void startAttemptTest() {

        Exam exam = new Exam();
        exam.setId(1L);
        exam.setTitle("Java Test");
        exam.setDurationMinutes(30);

        User student = new User();
        student.setId(1L);
        student.setEmail("student@gmail.com");

        when(examRepository.findById(1L))
                .thenReturn(Optional.of(exam));

        when(userRepository.findByEmail("student@gmail.com"))
                .thenReturn(Optional.of(student));

        when(attemptRepository.findByStudentIdAndExamId(1L, 1L))
                .thenReturn(java.util.List.of());

        StudentAttempt attempt = new StudentAttempt();
        attempt.setId(10L);

        when(attemptRepository.save(any(StudentAttempt.class)))
                .thenReturn(attempt);

        var result = attemptService.startAttempt(1L, "student@gmail.com");

        assertEquals(1L, result.getExamId());
        assertEquals(1, result.getAttemptNumber());
    }
}