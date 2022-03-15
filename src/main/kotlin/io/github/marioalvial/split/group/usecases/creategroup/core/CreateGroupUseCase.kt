package io.github.marioalvial.split.group.usecases.creategroup.core

import io.github.marioalvial.split.group.domain.Group
import io.github.marioalvial.split.group.usecases.shared.core.ports.GroupRepository
import io.github.marioalvial.split.user.usecases.getuserbyid.core.GetUserByIdUseCase
import java.util.UUID

class CreateGroupUseCase(
    private val findUserByIdUseCase: GetUserByIdUseCase,
    private val groupRepository: GroupRepository
) {

    fun execute(createGroupInput: CreateGroupInput): Group {
        val ownerId = UUID.fromString(createGroupInput.ownerId)
        val owner = findUserByIdUseCase.execute(ownerId)
        val group = Group.create(createGroupInput, owner)

        groupRepository.save(group)

        return group
    }
}