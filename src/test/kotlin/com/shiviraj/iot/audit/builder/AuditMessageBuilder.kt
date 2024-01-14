package com.shiviraj.iot.audit.builder

import com.shiviraj.iot.mqtt.model.AuditEvent
import com.shiviraj.iot.mqtt.model.AuditMessage
import com.shiviraj.iot.mqtt.model.AuditStatus
import java.time.LocalDateTime

data class AuditMessageBuilder(
    val status: AuditStatus = AuditStatus.SUCCESS,
    val userId: String = "",
    val accountId: String? = null,
    val deviceId: String? = null,
    val metadata: Map<String, Any> = mapOf(),
    val event: AuditEvent = AuditEvent.RESET_PASSWORD,
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    fun build(): AuditMessage {
        return AuditMessage(
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
