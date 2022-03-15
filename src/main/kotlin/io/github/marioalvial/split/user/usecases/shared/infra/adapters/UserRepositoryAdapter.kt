package io.github.marioalvial.split.user.usecases.shared.infra.adapters

import io.github.marioalvial.split.user.domain.User
import io.github.marioalvial.split.user.usecases.shared.core.ports.UserRepository
import io.github.marioalvial.split.user.usecases.shared.infra.database.UserTable
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.UUID

class UserRepositoryAdapter : UserRepository {

    override fun save(user: User) {
        transaction {
            UserTable.insert {
                it[uuid] = user.id
                it[name] = user.name
                it[email] = user.email
                it[password] = user.password
            }
        }
    }

    override fun list(limit: Int, cursor: Int) = transaction {
        val limitPlusOne = limit + 1
        val result = UserTable
            .select { UserTable.id greaterEq cursor }
            .limit(limitPlusOne)
        val numberOfRows = result.count().toInt()

        if (numberOfRows == limitPlusOne) {
            val isLastPage = false
            val users = result
                .map { UserTable.toUser(it) }
                .dropLast(1)

            users to isLastPage
        } else {
            val isLastPage = true
            val users = result
                .map { UserTable.toUser(it) }

            users to isLastPage
        }
    }

    override fun findById(id: UUID) = transaction {
        UserTable.select { UserTable.uuid eq id }
            .firstOrNull()
            ?.let { UserTable.toUser(it) }
    }
}