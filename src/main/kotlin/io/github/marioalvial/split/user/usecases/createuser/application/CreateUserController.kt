package io.github.marioalvial.split.user.usecases.createuser.application

import io.github.marioalvial.split.user.usecases.createuser.application.requests.CreateUserRequest
import io.github.marioalvial.split.user.usecases.createuser.application.responses.CreateUserResponse
import io.github.marioalvial.split.user.usecases.createuser.core.CreateUserUseCase
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond

class CreateUserController(
    private val createUserUseCase: CreateUserUseCase
) {

    suspend fun execute(call: ApplicationCall){
        val request = call.receive<CreateUserRequest>()
        val command = request.toCommand()
        val user = createUserUseCase.execute(command)
        val response = CreateUserResponse.create(user)

        return call.respond(HttpStatusCode.Created, response)
    }
}