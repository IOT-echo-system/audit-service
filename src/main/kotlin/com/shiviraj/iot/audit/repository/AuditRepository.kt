package com.shiviraj.iot.audit.repository

import com.shiviraj.iot.audit.model.Audit
import com.shiviraj.iot.audit.model.AuditId
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuditRepository : ReactiveCrudRepository<Audit, AuditId>
