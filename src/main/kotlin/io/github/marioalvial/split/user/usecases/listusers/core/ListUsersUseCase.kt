package io.github.marioalvial.split.user.usecases.listusers.core

import io.github.marioalvial.split.user.domain.User
import io.github.marioalvial.split.user.usecases.shared.core.ports.UserRepository

class ListUsersUseCase(
    private val userRepository: UserRepository
) {

    fun execute(limit: Int, cursor: Int): Pair<List<User>, Boolean> = userRepository.list(limit, cursor)
}