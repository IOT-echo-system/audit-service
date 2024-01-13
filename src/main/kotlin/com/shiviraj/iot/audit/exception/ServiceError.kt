package com.shiviraj.iot.audit.exception

import com.shiviraj.iot.userService.exceptions.ServiceError


enum class IOTError(override val errorCode: String, override val message: String) : ServiceError {
//    IOT0201("IOT-0201", "User already registered with this email."),
}
