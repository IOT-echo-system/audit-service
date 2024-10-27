package com.robotutor.audit.exception

import com.robotutor.iot.exceptions.ServiceError


enum class IOTError(override val errorCode: String, override val message: String) : ServiceError {
//    IOT0201("IOT-0201", "User already registered with this email."),
}
