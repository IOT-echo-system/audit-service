package com.shiviraj.iot.audit.service

import com.shiviraj.iot.audit.model.Audit
import com.shiviraj.iot.audit.model.IdType
import com.shiviraj.iot.audit.repository.AuditRepository
import com.shiviraj.iot.loggingstarter.logOnError
import com.shiviraj.iot.loggingstarter.logOnSuccess
import com.shiviraj.iot.mqtt.model.AuditMessage
import com.shiviraj.iot.utils.service.IdGeneratorService
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class AuditService(private val auditRepository: AuditRepository, private val idGeneratorService: IdGeneratorService) {
    fun addAudit(auditMessage: AuditMessage): Mono<Audit> {
        return idGeneratorService.generateId(IdType.AUDIT_ID)
            .flatMap { auditId ->
                auditRepository.save(Audit.from(auditId, auditMessage))
            }
            .logOnSuccess(message = "Successfully added new audit")
            .logOnError(errorMessage = "Failed to add new audit")
    }
}
