package io.github.marioalvial.split.group.usecases.shared.core

import io.github.marioalvial.split.group.domain.Group
import io.github.marioalvial.split.user.domain.User
import kotlinx.serialization.Serializable

@Serializable
class GroupOutput(
    val id: String,
    val name: String,
    val ownerId: String,
    val users: List<UserGroupOutput>
) : java.io.Serializable {

    companion object{
        fun create(group: Group) = GroupOutput(
            id = group.id.toString(),
            name = group.name,
            ownerId = group.ownerId.toString(),
            users = group.users.map { UserGroupOutput.create(it) }
        )
    }
}

@Serializable
class UserGroupOutput(
    val id: String,
    val name: String
) : java.io.Serializable{

    companion object{
        fun create(user: User) = UserGroupOutput(
            id = user.id.toString(),
            name = user.name
        )
    }
}