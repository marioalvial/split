package io.github.marioalvial.split.group.usecases.creategroup.application

import io.github.marioalvial.split.group.usecases.creategroup.core.CreateGroupInput
import io.github.marioalvial.split.group.usecases.creategroup.core.CreateGroupUseCase
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond

class CreateGroupController(
    private val createGroupUseCase: CreateGroupUseCase
) {

    suspend fun execute(call: ApplicationCall){
        val createGroupInput = call.receive<CreateGroupInput>()
        val groupOutput = createGroupUseCase.execute(createGroupInput)

        return call.respond(HttpStatusCode.Created, groupOutput)
    }
}