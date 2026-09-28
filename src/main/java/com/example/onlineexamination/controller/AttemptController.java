package com.example.onlineexamination.controller;

import com.example.onlineexamination.dto.StartAttemptResponse;
import com.example.onlineexamination.dto.SubmitAttemptRequest;
import com.example.onlineexamination.entity.StudentAttempt;
import com.example.onlineexamination.service.AttemptService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/attempts")
public class AttemptController {

    private final AttemptService attemptService;

    public AttemptController(AttemptService attemptService) {
        this.attemptService = attemptService;
    }

    @PostMapping("/start/{examId}")
    public ResponseEntity<StartAttemptResponse> startAttempt(
            @PathVariable Long examId,
            Authentication authentication) {

        return ResponseEntity.ok(
                attemptService.startAttempt(
                        examId,
                        authentication.getName()
                )
        );
    }

    @PostMapping("/{attemptId}/submit")
    public ResponseEntity<Double> submitAttempt(
            @PathVariable Long attemptId,
            @RequestBody SubmitAttemptRequest request,
            Authentication authentication) {

        return ResponseEntity.ok(
                attemptService.submitAttempt(
                        attemptId,
                        authentication.getName(),
                        request
                )
        );
    }

    @GetMapping("/history")
    public ResponseEntity<List<StudentAttempt>> history(
            Authentication authentication) {

        return ResponseEntity.ok(
                attemptService.getHistory(authentication.getName())
        );
    }
}