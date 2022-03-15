package io.github.marioalvial.split.group.usecases.shared.core.ports

import io.github.marioalvial.split.group.domain.Group
import java.util.UUID

interface GroupRepository {

    fun save(group: Group)

    fun addUser(groupId: UUID, userId: UUID)

    fun findById(id: UUID): Group?
}