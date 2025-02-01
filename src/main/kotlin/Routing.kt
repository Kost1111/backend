package ru.local

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import java.time.Duration
import kotlin.time.Duration.Companion.seconds

fun Application.configureRouting() {
    routing {
        get("/first") {
            call.respondText("Hello World!")
        }
    }
}

fun Application.firstGetRouting() {
    routing {
        get("/get_routing") {
            call.respondText("Говно")
        }
    }
}
