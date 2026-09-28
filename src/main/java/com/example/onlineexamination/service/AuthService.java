package com.example.onlineexamination.service;

import com.example.onlineexamination.dto.AuthResponse;
import com.example.onlineexamination.dto.LoginRequest;
import com.example.onlineexamination.dto.RegisterRequest;

public interface AuthService {

    String register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}