package io.github.marioalvial.split.group.usecases.shared.infra.adapters

import io.github.marioalvial.split.group.domain.Group
import io.github.marioalvial.split.group.usecases.shared.core.ports.GroupRepository
import io.github.marioalvial.split.group.usecases.shared.infra.adapters.GroupTable.toGroups
import io.github.marioalvial.split.user.domain.User
import io.github.marioalvial.split.user.usecases.shared.infra.database.UserTable
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.UUID

internal object GroupTable : UUIDTable("groups") {
    val name = varchar("name", 255)
    val ownerId = uuid("owner_id")

    fun Iterable<ResultRow>.toGroups(): List<Group> {
        val result = this.fold(mutableMapOf<UUID, Group>()) { map, resultRow ->
            val groupId = resultRow[GroupTable.id].value
            var group = map[groupId]

            if (group == null) {
                val user = UserTable.toUser(resultRow)

                group = createGroup(groupId, resultRow, user)
                map[group.id] = group
            } else {
                val user = UserTable.toUser(resultRow)
                val userListUpdated = group.users + user

                group = group.copy(users = userListUpdated.toMutableList())
            }

            map.apply { this[group.id] = group }
        }

        return result.values.toList()
    }

    private fun createGroup(groupId: UUID, resultRow: ResultRow, user: User) = Group(
        id = groupId,
        name = resultRow[name],
        ownerId = user.id,
        users = mutableListOf(user)
    )
}

internal object GroupUserTable : Table("groups_users") {
    val groupId = reference("group_id", GroupTable.id)
    val userId = reference("user_id", UserTable.uuid)
}

class GroupRepositoryAdapter : GroupRepository {

    override fun save(group: Group) {
        transaction {
            GroupTable.insert {
                it[id] = group.id
                it[name] = group.name
                it[ownerId] = group.ownerId
            }

            group
                .users
                .forEach { user ->
                    GroupUserTable.insert {
                        it[groupId] = group.id
                        it[userId] = user.id
                    }
                }
        }
    }

    override fun addUser(groupId: UUID, userId: UUID) {
        transaction {
            GroupUserTable.insert {
                it[GroupUserTable.groupId] = groupId
                it[GroupUserTable.userId] = userId
            }
        }
    }

    override fun findById(id: UUID) = transaction {
        (GroupTable leftJoin GroupUserTable leftJoin UserTable)
            .select { GroupTable.id eq id }
            .toGroups()
            .singleOrNull()
    }
}
