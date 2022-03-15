package io.github.marioalvial.split.user.usecases.createuser.core

import io.github.marioalvial.split.user.domain.User
import io.github.marioalvial.split.user.usecases.createuser.core.commands.CreateUserCommand
import io.github.marioalvial.split.user.usecases.createuser.core.factories.UserFactory
import io.github.marioalvial.split.user.usecases.createuser.core.ports.CryptService
import io.github.marioalvial.split.user.usecases.shared.core.ports.UserRepository

class CreateUserUseCase(
    private val userRepository: UserRepository,
    private val cryptService: CryptService
) {

    fun execute(command: CreateUserCommand): User {
        val cryptPassword = cryptService.encrypt(command.password)
        val user = UserFactory.create(command, cryptPassword)

        userRepository.save(user)

        return user
    }
}