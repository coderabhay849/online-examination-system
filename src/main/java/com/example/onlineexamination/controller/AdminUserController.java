package com.example.onlineexamination.controller;

import com.example.onlineexamination.dto.AdminUserRequest;
import com.example.onlineexamination.service.AdminUserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/users")
public class AdminUserController {

    private final AdminUserService adminUserService;

    public AdminUserController(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(
            @Valid @RequestBody AdminUserRequest request) {

        return ResponseEntity.ok(
                adminUserService.createUser(request)
        );
    }
}