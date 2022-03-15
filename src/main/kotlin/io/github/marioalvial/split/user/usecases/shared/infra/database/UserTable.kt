package io.github.marioalvial.split.user.usecases.shared.infra.database

import io.github.marioalvial.split.user.domain.User
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ResultRow

internal object UserTable : IntIdTable("users", "pk") {

    val uuid = uuid("id")
    val name = varchar("name", 255)
    val email = varchar("email", 255)
    val password = varchar("password", 255)

    fun toUser(resultRow: ResultRow) = User(
        id = resultRow[uuid],
        name = resultRow[name],
        email = resultRow[email],
        password = resultRow[password],
        sequentialId = resultRow[id].value
    )
}