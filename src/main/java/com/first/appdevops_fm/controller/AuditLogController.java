package com.first.appdevops_fm.controller;

import com.first.appdevops_fm.entity.AuditLog;
import com.first.appdevops_fm.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/audit-logs")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    @PostMapping
    public AuditLog createAuditLog(@RequestBody AuditLog auditLog) {
        return auditLogService.createAuditLog(auditLog);
    }

    @GetMapping
    public List<AuditLog> getAllAuditLogs() {
        return auditLogService.getAllAuditLogs();
    }

    @GetMapping("/{id}")
    public Optional<AuditLog> getAuditLogById(@PathVariable Long id) {
        return auditLogService.getAuditLogById(id);
    }
}