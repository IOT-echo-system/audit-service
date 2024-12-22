package com.robotutor.audit.builder

import com.robotutor.audit.model.Audit
import com.robotutor.audit.model.AuditId
import com.robotutor.iot.models.AuditStatus
import org.bson.types.ObjectId
import java.time.LocalDateTime

data class AuditBuilder(
    val id: ObjectId? = null,
    val auditId: AuditId = "",
    val status: AuditStatus = AuditStatus.SUCCESS,
    val userId: String = "",
    val deviceId: String? = null,
    val metadata: Map<String, Any> = mapOf(),
    val event: String = "",
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    fun build(): Audit {
        return Audit(
            id = id,
            auditId = auditId,
            status = status,
            userId = userId,
            deviceId = deviceId,
            metadata = metadata,
            event = event,
            timestamp = timestamp,
        )
    }
}
