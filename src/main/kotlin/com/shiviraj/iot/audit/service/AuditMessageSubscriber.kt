package com.shiviraj.iot.audit.service

import com.shiviraj.iot.mqtt.model.AuditMessage
import com.shiviraj.iot.mqtt.model.MqttTopicName
import com.shiviraj.iot.mqtt.service.MqttSubscriber
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
