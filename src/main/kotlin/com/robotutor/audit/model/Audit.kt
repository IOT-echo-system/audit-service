package com.robotutor.audit.model

import com.robotutor.iot.models.AuditMessage
import com.robotutor.iot.models.AuditStatus
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

const val AUDIT_COLLECTION = "audit"

@TypeAlias("Audit")
@Document(AUDIT_COLLECTION)
data class Audit(
    @Id
    var id: ObjectId? = null,
    @Indexed(unique = true)
    val auditId: AuditId,
    val status: AuditStatus,
    val userId: String,
    val premisesId: String?,
    val metadata: Map<String, Any?>,
    val event: String,
    val timestamp: LocalDateTime
) {
    companion object {
        fun from(auditId: String, message: AuditMessage): Audit {
            return Audit(
                auditId = auditId,
                status = message.status,
                userId = message.userId,
                metadata = message.metadata,
                event = message.event,
                timestamp = message.timestamp,
                premisesId = message.premisesId,
            )
        }
    }
}

typealias AuditId = String

