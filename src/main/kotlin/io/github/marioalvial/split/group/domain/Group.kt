package io.github.marioalvial.split.group.domain

import io.github.marioalvial.split.group.usecases.creategroup.core.CreateGroupInput
import io.github.marioalvial.split.user.domain.User
import java.util.UUID

data class Group(
    val id: UUID,
    val name: String,
    val ownerId: UUID,
    val users: MutableList<User>
) {

    fun addUser(user: User) {
        if (users.any { it.id == user.id }) {
            throw RuntimeException("User already added to group")
        }

        users.add(user)
    }

    companion object {
        fun create(createGroupInput: CreateGroupInput, owner: User) = Group(
            id = UUID.randomUUID(),
            name = createGroupInput.name,
            ownerId = owner.id,
            users = mutableListOf(owner)
        )
    }
}

