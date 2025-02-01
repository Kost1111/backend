package ru.local.routing.registration

import feature.registration.RegistrationModel
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.local.feature.registration.RegistrationResult
import ru.local.util.localStorage.LocalData
import ru.local.util.localStorage.UserData
import java.util.*

fun Application.registrationRouting() {
    routing {
        post("/registration") {
            val registrationData = call.receive<RegistrationModel>()

            val existingUser = LocalData.data.find { it.login == registrationData.login }

            if (existingUser != null) {
                call.respond(HttpStatusCode.OK, RegistrationResult(token = existingUser.token))
            } else {
                val newToken = UUID.randomUUID().toString()
                LocalData.data.add(UserData(login = registrationData.login, token = newToken))

                call.respond(HttpStatusCode.OK, RegistrationResult(token = newToken))
            }
        }
    }
}