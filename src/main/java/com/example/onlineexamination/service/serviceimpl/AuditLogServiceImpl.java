package com.example.onlineexamination.service.serviceimpl;

import com.example.onlineexamination.entity.AuditLog;
import com.example.onlineexamination.repository.AuditLogRepository;
import com.example.onlineexamination.service.AuditLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLogServiceImpl(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @Override
    public void saveLog(String action, String username, String details) {

        AuditLog log = new AuditLog();

        log.setAction(action);
        log.setUsername(username);
        log.setDetails(details);
        log.setCreatedAt(LocalDateTime.now());

        auditLogRepository.save(log);
    }
}