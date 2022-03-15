package io.github.marioalvial.split.user.usecases.shared.core

import io.github.marioalvial.split.user.domain.User
import kotlinx.serialization.Serializable

@Serializable
class UserOutput(
    val id: String,
    val name: String,
    val email: String
) : java.io.Serializable {

    companion object{
        fun create(user: User) = UserOutput(
            id = user.id.toString(),
            name = user.name,
            email = user.email
        )
    }
}