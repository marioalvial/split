package io.github.marioalvial.split.user.usecases.listusers.application

import io.github.marioalvial.split.user.domain.User
import kotlinx.serialization.Serializable

@Serializable
class ListUsersResponse(
    val users: List<UserListUsersResponse>,
    val cursor: Cursor
) : java.io.Serializable {

    companion object{
        fun create(users: List<User>, isLastPage:Boolean): ListUsersResponse {
            val firstUser = users.firstOrNull()
            val previousPage = if(firstUser?.sequentialId == 1) null else firstUser?.sequentialId?.minus(1)
            val nextPage = if(isLastPage) null else users.lastOrNull()?.sequentialId?.plus(1)
            val cursor = Cursor.create(previousPage, nextPage)

            return ListUsersResponse(
                users = users.map { UserListUsersResponse.create(it) },
                cursor = cursor
            )
        }
    }
}

@Serializable
class UserListUsersResponse(
    val id: String,
    val name: String
) : java.io.Serializable{

    companion object{
        fun create(user: User) = UserListUsersResponse(
            id = user.id.toString(),
            name = user.name
        )
    }
}

@Serializable
class Cursor(
    val previous: Int?,
    val next: Int?
) : java.io.Serializable{
    companion object{
        fun create(previous: Int?, next: Int?) = Cursor(
            previous = previous,
            next = next
        )
    }
}