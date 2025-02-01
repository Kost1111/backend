package ru.local

import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import ru.local.routing.auth.authRouting
import ru.local.routing.registration.registrationRouting
import ru.local.socket.configureSockets
import ru.local.util.serialization.configureSerialization

fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSockets()
    configureSerialization()
    registrationRouting()
    authRouting()
}


