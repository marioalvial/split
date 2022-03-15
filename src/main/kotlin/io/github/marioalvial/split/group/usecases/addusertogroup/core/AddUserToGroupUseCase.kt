package io.github.marioalvial.split.group.usecases.addusertogroup.core

import io.github.marioalvial.split.group.usecases.shared.core.GroupOutput
import io.github.marioalvial.split.group.usecases.shared.core.ports.GroupRepository
import io.github.marioalvial.split.user.usecases.getuserbyid.core.GetUserByIdUseCase
import java.util.UUID

class AddUserToGroupUseCase(
    private val groupRepository: GroupRepository,
    private val getUserByIdUseCase: GetUserByIdUseCase
) {

    fun execute(groupId: UUID, userId: UUID): GroupOutput {
        val group = groupRepository
            .findById(groupId)
            ?: throw RuntimeException("Group not found")
        val user = getUserByIdUseCase.execute(userId)

        group.addUser(user)
        groupRepository.addUser(group.id, user.id)

        return GroupOutput.create(group)
    }
}