package ru.local.routing.auth

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.local.feature.auth.AuthModel
import ru.local.feature.registration.RegistrationResult
import ru.local.util.localStorage.LocalData


fun Application.authRouting() {
    routing {
        post("/auth") {

            val authData = call.receive<AuthModel>()

            val existingUser = LocalData.data.find { it.login == authData.login }

            if (existingUser != null) {
                call.respond(HttpStatusCode.OK, RegistrationResult(token = existingUser.token))
            } else {
                call.respond(HttpStatusCode.Unauthorized, "You are not registered")
            }
        }
    }
}