package io.github.marioalvial.split.user.usecases.listusers.application

import io.github.marioalvial.split.user.usecases.listusers.core.ListUsersUseCase
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond

class ListUsersController(
    private val listUsersUseCase: ListUsersUseCase
) {

    suspend fun execute(call: ApplicationCall){
        val limit = call.request.queryParameters["limit"]?.toInt() ?: 10
        val cursor = call.request.queryParameters["cursor"]?.toInt() ?: 1
        val (users, isLastPage) = listUsersUseCase.execute(limit, cursor)
        val response = ListUsersResponse.create(users, isLastPage)

        return call.respond(HttpStatusCode.OK, response)
    }
}