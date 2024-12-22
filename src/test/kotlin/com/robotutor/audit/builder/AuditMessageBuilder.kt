package com.robotutor.audit.builder

import com.robotutor.iot.models.AuditMessage
import com.robotutor.iot.models.AuditStatus
import java.time.LocalDateTime

data class AuditMessageBuilder(
    val status: AuditStatus = AuditStatus.SUCCESS,
    val userId: String = "",
    val deviceId: String? = null,
    val metadata: Map<String, Any?> = mapOf(),
    val event: String = "",
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    fun build(): AuditMessage {
        return AuditMessage(
            status = status,
            userId = userId,
            deviceId = deviceId,
            metadata = metadata,
            event = event,
            timestamp = timestamp,
        )
    }
}
