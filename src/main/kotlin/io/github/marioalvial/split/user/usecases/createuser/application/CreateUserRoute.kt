package io.github.marioalvial.split.user.usecases.createuser.application

import io.ktor.application.call
import io.ktor.routing.Route
import io.ktor.routing.post

        fun Route.createUser(controller: CreateUserController) {
        post { controller.execute(call) }
}