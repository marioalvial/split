package io.github.marioalvial.split.user.usecases.createuser.application.responses

import io.github.marioalvial.split.user.domain.User
import kotlinx.serialization.Serializable

@Serializable
class CreateUserResponse(
    val id: String,
    val name: String,
    val email: String
) : java.io.Serializable {

    companion object{
        fun create(user: User) = CreateUserResponse(
            id = user.id.toString(),
            name = user.name,
            email = user.email
        )
    }
}