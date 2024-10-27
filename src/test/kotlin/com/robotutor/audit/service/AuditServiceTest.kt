package com.robotutor.audit.service

import com.robotutor.audit.builder.AuditBuilder
import com.robotutor.audit.builder.AuditMessageBuilder
import com.robotutor.audit.model.IdType
import com.robotutor.audit.repository.AuditRepository
import com.robotutor.audit.testUtils.assertNextWith
import com.robotutor.iot.service.IdGeneratorService
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import reactor.core.publisher.Mono
import java.time.LocalDateTime

class AuditServiceTest {
    private val auditRepository = mockk<AuditRepository>()
    private val idGeneratorService = mockk<IdGeneratorService>()
    private val auditService = AuditService(auditRepository = auditRepository, idGeneratorService = idGeneratorService)

    @BeforeEach
    fun setUp() {
        clearAllMocks()
    }

    @AfterEach
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `should add new audit`() {
        val auditMessage = AuditMessageBuilder(timestamp = LocalDateTime.of(2024, 1, 1, 1, 1)).build()
        val audit = AuditBuilder(auditId = "AuditId", timestamp = LocalDateTime.of(2024, 1, 1, 1, 1)).build()

        every { idGeneratorService.generateId(any()) } returns Mono.just("AuditId")
        every { auditRepository.save(any()) } returns Mono.just(audit)

        val response = auditService.addAudit(auditMessage)

        assertNextWith(response) {
            it shouldBe audit

            verify(exactly = 1) {
                idGeneratorService.generateId(IdType.AUDIT_ID)
                auditRepository.save(audit)
            }
        }
    }
}
