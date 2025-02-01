package ru.local.feature.registration

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationResult(
    val token: String
)