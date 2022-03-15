package io.github.marioalvial.split.group.usecases.getgroupbyid.application

import io.ktor.application.call
import io.ktor.routing.Route
import io.ktor.routing.get

fun Route.getGroupById(controller: GetGroupByIdController) {
    get("{id}") { controller.execute(call) }
}