package com.robotutor.audit.repository

import com.robotutor.audit.model.Audit
import com.robotutor.audit.model.AuditId
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuditRepository : ReactiveCrudRepository<Audit, AuditId>
