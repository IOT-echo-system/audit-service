package com.robotutor.audit.service

import com.robotutor.iot.models.AuditMessage
import com.robotutor.iot.models.KafkaTopicName
import com.robotutor.iot.services.KafkaConsumer
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service

@Service
class AuditMessageSubscriber(
    private val auditService: AuditService,
    private val kafkaConsumer: KafkaConsumer,
) {
    @PostConstruct
    fun subscribe() {
        kafkaConsumer.consume(listOf(KafkaTopicName.AUDIT), AuditMessage::class.java) { _, msg ->
            auditService.addAudit(msg).subscribe()
        }
    }
}
