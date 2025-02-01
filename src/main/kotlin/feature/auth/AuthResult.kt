package ru.local.feature.auth

import kotlinx.serialization.Serializable

@Serializable
data class AuthResult(val token: String)