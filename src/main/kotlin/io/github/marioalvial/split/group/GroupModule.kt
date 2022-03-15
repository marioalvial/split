package io.github.marioalvial.split.group

import io.github.marioalvial.split.group.usecases.addusertogroup.addUserToGroupModule
import io.github.marioalvial.split.group.usecases.creategroup.createGroupModule
import io.github.marioalvial.split.group.usecases.getgroupbyid.getGroupByIdModule
import io.github.marioalvial.split.group.usecases.shared.core.ports.GroupRepository
import io.github.marioalvial.split.group.usecases.shared.infra.adapters.GroupRepositoryAdapter
import org.koin.dsl.module

val groupModule = module {
    single<GroupRepository> { GroupRepositoryAdapter() }
    createGroupModule()
    getGroupByIdModule()
    addUserToGroupModule()
}