package com.shiviraj.iot.audit.builder

import com.shiviraj.iot.audit.model.Audit
import com.shiviraj.iot.audit.model.AuditId
import com.shiviraj.iot.mqtt.model.AuditEvent
import com.shiviraj.iot.mqtt.model.AuditStatus
import org.bson.types.ObjectId
import java.time.LocalDateTime

data class AuditBuilder(
    val id: ObjectId? = null,
    val auditId: AuditId = "",
    val status: AuditStatus = AuditStatus.SUCCESS,
    val userId: String = "",
    val accountId: String? = null,
    val deviceId: String? = null,
    val metadata: Map<String, Any> = mapOf(),
    val event: AuditEvent = AuditEvent.RESET_PASSWORD,
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    fun build(): Audit {
        return Audit(
            id = id,
            auditId = auditId,
            status = status,
            userId = userId,
            accountId = accountId,
            deviceId = deviceId,
            metadata = metadata,
            event = event,
            timestamp = timestamp,
        )
    }
}
