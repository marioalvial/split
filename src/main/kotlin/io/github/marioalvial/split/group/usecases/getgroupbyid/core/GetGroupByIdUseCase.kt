package io.github.marioalvial.split.group.usecases.getgroupbyid.core

import io.github.marioalvial.split.group.usecases.shared.core.GroupOutput
import io.github.marioalvial.split.group.usecases.shared.core.ports.GroupRepository
import java.util.UUID

class GetGroupByIdUseCase(
    private val groupRepository: GroupRepository
) {

    fun execute(id: UUID): GroupOutput {
        val group = groupRepository
            .findById(id)
            ?: throw RuntimeException("Group not found")

        return GroupOutput.create(group)
    }
}