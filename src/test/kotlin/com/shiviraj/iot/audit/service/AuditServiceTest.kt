package com.shiviraj.iot.audit.service

import com.shiviraj.iot.audit.builder.AuditBuilder
import com.shiviraj.iot.audit.model.IdType
import com.shiviraj.iot.audit.repository.AuditRepository
import com.shiviraj.iot.audit.testUtils.assertNextWith
import com.shiviraj.iot.mqtt.model.AuditMessageBuilder
import com.shiviraj.iot.utils.service.IdGeneratorService
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
        val audit = AuditBuilder(auditId = "AuditId", accountId = "", deviceId = "", timestamp = LocalDateTime.of(2024, 1, 1, 1, 1)).build()

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
