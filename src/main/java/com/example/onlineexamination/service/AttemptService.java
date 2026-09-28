package com.example.onlineexamination.service;

import com.example.onlineexamination.dto.StartAttemptResponse;
import com.example.onlineexamination.dto.SubmitAttemptRequest;
import com.example.onlineexamination.entity.StudentAttempt;

import java.util.List;

public interface AttemptService {

    StartAttemptResponse startAttempt(Long examId, String email);

    Double submitAttempt(Long attemptId, String email,
                         SubmitAttemptRequest request);

    List<StudentAttempt> getHistory(String email);
}