package com.robotutor.audit.service

import com.robotutor.audit.model.Audit
import com.robotutor.audit.model.IdType
import com.robotutor.audit.repository.AuditRepository
import com.robotutor.iot.models.AuditMessage
import com.robotutor.iot.service.IdGeneratorService
import com.robotutor.loggingstarter.Logger
import com.robotutor.loggingstarter.logOnSuccess
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class AuditService(private val auditRepository: AuditRepository, private val idGeneratorService: IdGeneratorService) {
    private val logger = Logger(this::class.java)
    fun addAudit(auditMessage: AuditMessage): Mono<Audit> {
        return idGeneratorService.generateId(IdType.AUDIT_ID)
            .flatMap { auditId ->
                auditRepository.save(Audit.from(auditId, auditMessage))
            }
            .logOnSuccess(logger, message = "Successfully added new audit")
    }
}
