package com.example;
public class SecurityManager {
    private final AuditService auditService;
    public SecurityManager(AuditService auditService) {
        this.auditService = auditService;
    }
    public void checkAccess(String userId) {
        auditService.logAccess(userId);
    }
}
