package com.example.onlineexamination.service;

public interface AuditLogService {

    void saveLog(String action, String username, String details);
}