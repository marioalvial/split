package io.github.marioalvial.split.user.usecases.shared.core.ports

import io.github.marioalvial.split.user.domain.User
import java.util.UUID

interface UserRepository {

    fun save(user: User)

    fun list(limit: Int, cursor: Int): Pair<List<User>, Boolean>

    fun findById(id: UUID): User?
}