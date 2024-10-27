package com.robotutor.audit.service

import com.robotutor.iot.models.AuditMessage
import com.robotutor.iot.models.MqttTopicName
import com.robotutor.iot.services.MqttSubscriber
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service

@Service
class AuditMessageSubscriber(
    private val auditService: AuditService,
    private val mqttSubscriber: MqttSubscriber,
) {
    @PostConstruct
    fun subscribe() {
        mqttSubscriber.subscribe(MqttTopicName.AUDIT, AuditMessage::class.java) { msg ->
            auditService.addAudit(msg).subscribe()
        }
    }
}
