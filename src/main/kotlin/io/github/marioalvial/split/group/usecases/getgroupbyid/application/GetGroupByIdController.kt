package io.github.marioalvial.split.group.usecases.getgroupbyid.application

import io.github.marioalvial.split.group.usecases.getgroupbyid.core.GetGroupByIdUseCase
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import java.util.UUID

class GetGroupByIdController(
    private val getGroupByIdUseCase: GetGroupByIdUseCase
) {

    suspend fun execute(call: ApplicationCall){
        val groupId = UUID.fromString(call.parameters["id"])
        val groupOutput = getGroupByIdUseCase.execute(groupId)

        return call.respond(HttpStatusCode.OK, groupOutput)
    }
}