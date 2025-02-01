package ru.local.socket

import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import kotlin.time.Duration.Companion.seconds

fun Application.configureSockets() {
    install(WebSockets) {
        pingPeriod = 15.seconds
        timeout = 15.seconds
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }

    routing {
        webSocket("/ws") {
            println("Client connected: ")

            outgoing.send(Frame.Text("Welcome to the WebSocket server!"))

            for (frame in incoming) {
                if (frame is Frame.Text) {
                    val text = frame.readText()
                    println("Received message: $text")

                    outgoing.send(Frame.Text("YOU SAID: $text"))

                    if (text.equals("bye", ignoreCase = true)) {
                        close(CloseReason(CloseReason.Codes.NORMAL, "Client said BYE"))
                    }
                }
            }
        }
    }
}