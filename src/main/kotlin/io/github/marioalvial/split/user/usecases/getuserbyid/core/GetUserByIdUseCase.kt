package io.github.marioalvial.split.user.usecases.getuserbyid.core

import io.github.marioalvial.split.user.usecases.shared.core.ports.UserRepository
import java.util.UUID

class GetUserByIdUseCase(
    private val userRepository: UserRepository
) {

    fun execute(id: UUID) = userRepository
        .findById(id)
        ?: throw RuntimeException("User not found")
}