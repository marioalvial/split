package io.github.marioalvial.split.user.usecases.listusers.application

import io.ktor.application.call
import io.ktor.routing.Route
import io.ktor.routing.get

fun Route.listUsers(controller: ListUsersController) {
        get { controller.execute(call) }
}