package feature.registration

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationModel(
    val login: String,
    val email: String,
    val password: String,
)