package com.example.onlineexamination.controller;

import com.example.onlineexamination.entity.Result;
import com.example.onlineexamination.service.ResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student/results")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/{attemptId}")
    public ResponseEntity<Result> getResult(
            @PathVariable Long attemptId,
            Authentication authentication) {

        return ResponseEntity.ok(
                resultService.getResult(
                        attemptId,
                        authentication.getName()
                )
        );
    }
    
    @GetMapping("/{attemptId}/download")
    public ResponseEntity<String> downloadResult(
            @PathVariable Long attemptId,
            Authentication authentication) {

        Result result = resultService.getResult(
                attemptId,
                authentication.getName()
        );

        String content =
                "ONLINE EXAMINATION RESULT\n\n" +
                "Attempt ID: " + result.getAttempt().getId() + "\n" +
                "Exam: " + result.getAttempt().getExam().getTitle() + "\n" +
                "Student: " + result.getAttempt().getStudent().getUsername() + "\n" +
                "Score: " + result.getScore() + "\n" +
                "Total Marks: " + result.getTotalMarks() + "\n" +
                "Percentage: " + result.getPercentage() + "%\n" +
                "Result: " + (result.isPassed() ? "PASS" : "FAIL");

        return ResponseEntity.ok()
                .header("Content-Disposition",
                        "attachment; filename=result-" + attemptId + ".txt")
                .body(content);
    }
}