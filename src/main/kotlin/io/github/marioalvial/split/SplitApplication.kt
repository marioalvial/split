package io.github.marioalvial.split

import io.github.marioalvial.split.config.configModule
import io.github.marioalvial.split.group.group
import io.github.marioalvial.split.group.groupModule
import io.github.marioalvial.split.user.user
import io.github.marioalvial.split.user.userModule
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.routing.routing
import io.ktor.serialization.json
import org.flywaydb.core.Flyway
import org.jetbrains.exposed.sql.Database
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.get
import javax.sql.DataSource

fun main(args: Array<String>) = io.ktor.server.netty.EngineMain.main(args)


fun Application.module() {
    install(ContentNegotiation) { json()}

    install(Koin){
        modules(configModule, userModule, groupModule)
    }

    routing {
        user()
        group()
    }

    startDatabase(get())
}


private fun startDatabase(dataSource: DataSource) {
    Flyway.configure().dataSource(dataSource).load().migrate()
    Database.connect(dataSource)
}