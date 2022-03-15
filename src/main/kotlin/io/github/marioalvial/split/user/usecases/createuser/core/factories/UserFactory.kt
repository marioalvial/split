package io.github.marioalvial.split.user.usecases.createuser.core.factories

import io.github.marioalvial.split.user.domain.User
import io.github.marioalvial.split.user.usecases.createuser.core.commands.CreateUserCommand
import java.util.UUID

object UserFactory {

    fun create(command: CreateUserCommand, cryptPassword: String) = User(
        id = UUID.randomUUID(),
        name = command.name,
        email = command.email,
        password = cryptPassword
    )
}