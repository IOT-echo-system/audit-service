package com.shiviraj.iot.audit.model

import com.shiviraj.iot.utils.service.IdSequenceType

enum class IdType(override val length: Int) : IdSequenceType {
    AUDIT_ID(16),
}
