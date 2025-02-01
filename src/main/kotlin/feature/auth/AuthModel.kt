package ru.local.feature.auth

import kotlinx.serialization.Serializable

@Serializable
data class AuthModel(
    val login: String,
    val password: String
)