package io.github.marioalvial.split.group.usecases.addusertogroup.application

import io.github.marioalvial.split.group.usecases.addusertogroup.core.AddUserToGroupUseCase
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import java.util.UUID

class AddUserToGroupController(
    private val addUserToGroupUseCase: AddUserToGroupUseCase
) {

    suspend fun execute(call: ApplicationCall){
        val groupId = UUID.fromString(call.parameters["groupId"])
        val userId = UUID.fromString(call.parameters["userId"])
        val groupOutput = addUserToGroupUseCase.execute(groupId, userId)

        return call.respond(HttpStatusCode.Accepted, groupOutput)
    }
}