package io.github.marioalvial.split.group.usecases.addusertogroup.application

import io.ktor.application.call
import io.ktor.routing.Route
import io.ktor.routing.post

fun Route.addUserToGroupRoute(controller: AddUserToGroupController) {
    post("{groupId}/users/{userId}") { controller.execute(call) }
}