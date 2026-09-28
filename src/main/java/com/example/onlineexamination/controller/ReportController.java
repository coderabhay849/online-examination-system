package com.example.onlineexamination.controller;

import com.example.onlineexamination.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Long>> getReports() {
        return ResponseEntity.ok(reportService.getReports());
    }
}