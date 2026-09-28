package com.example.onlineexamination.service;

import com.example.onlineexamination.entity.Result;

public interface ResultService {

    Result getResult(Long attemptId, String email);
    
    String publishResult(Long attemptId);
}