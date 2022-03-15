package io.github.marioalvial.split.group

import io.github.marioalvial.split.group.usecases.addusertogroup.application.addUserToGroupRoute
import io.github.marioalvial.split.group.usecases.creategroup.application.createGroup
import io.github.marioalvial.split.group.usecases.getgroupbyid.application.getGroupById
import io.ktor.routing.Routing
import io.ktor.routing.route
import org.koin.ktor.ext.get

fun Routing.group() {
    route("/groups") {
        createGroup(get())
        getGroupById(get())
        addUserToGroupRoute(get())
    }
}
