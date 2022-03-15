package io.github.marioalvial.split.group.usecases.creategroup.application

import io.ktor.application.call
import io.ktor.routing.Route
import io.ktor.routing.post

fun Route.createGroup(controller: CreateGroupController) {
    post { controller.execute(call) }
}