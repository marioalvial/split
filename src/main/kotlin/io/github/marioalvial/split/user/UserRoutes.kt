package io.github.marioalvial.split.user

import io.github.marioalvial.split.user.usecases.createuser.application.createUser
import io.github.marioalvial.split.user.usecases.listusers.application.listUsers
import io.ktor.routing.Routing
import io.ktor.routing.route
import org.koin.ktor.ext.get

fun Routing.user() {
    route("/users") {
        createUser(get())
        listUsers(get())
    }
}
