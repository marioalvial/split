package io.github.marioalvial.split.group.usecases.creategroup

import io.github.marioalvial.split.group.usecases.creategroup.application.CreateGroupController
import io.github.marioalvial.split.group.usecases.creategroup.core.CreateGroupUseCase
import org.koin.core.module.Module

fun Module.createGroupModule() {
    single { CreateGroupController(get()) }
    single { CreateGroupUseCase(get(), get()) }
}