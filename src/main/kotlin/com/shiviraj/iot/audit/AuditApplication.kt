package com.shiviraj.iot.audit

import com.shiviraj.iot.mqtt.config.MqttConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.shiviraj.iot.utils", "com.shiviraj.iot.mqtt"])
@ConfigurationPropertiesScan
@EnableConfigurationProperties(MqttConfig::class)
class AuditApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplicationBuilder(AuditApplication::class.java).run(*args)
        }
    }
}

