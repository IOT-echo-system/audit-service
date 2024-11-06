package com.robotutor.audit

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.robotutor"])
@ConfigurationPropertiesScan(basePackages = ["com.robotutor"])
class AuditApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplicationBuilder(AuditApplication::class.java).run(*args)
        }
    }
}