package com.robotutor.audit.model

import com.robotutor.iot.service.IdSequenceType


enum class IdType(override val length: Int) : IdSequenceType {
    AUDIT_ID(16),
}
