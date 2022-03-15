package io.github.marioalvial.split.user.usecases.createuser.application.requests

import io.github.marioalvial.split.user.usecases.createuser.core.commands.CreateUserCommand
import kotlinx.serialization.Serializable

@Serializable
class CreateUserRequest(
    val name: String,
    val email: String,
    val password: String
) : java.io.Serializable{

    fun toCommand() = CreateUserCommand(
        name = name,
        email = email,
        password = password
    )
}