package com.example.onlineexamination.controller;

import com.example.onlineexamination.dto.OptionRequest;
import com.example.onlineexamination.entity.Option;
import com.example.onlineexamination.service.OptionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructor/options")
public class OptionController {

    private final OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @PostMapping
    public ResponseEntity<Option> createOption(
            @Valid @RequestBody OptionRequest request) {
        return ResponseEntity.ok(optionService.createOption(request));
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<Option>> getOptions(
            @PathVariable Long questionId) {
        return ResponseEntity.ok(optionService.getOptionsByQuestion(questionId));
    }
}