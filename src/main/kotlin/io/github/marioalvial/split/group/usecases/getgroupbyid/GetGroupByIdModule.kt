package io.github.marioalvial.split.group.usecases.getgroupbyid

import io.github.marioalvial.split.group.usecases.getgroupbyid.application.GetGroupByIdController
import io.github.marioalvial.split.group.usecases.getgroupbyid.core.GetGroupByIdUseCase
import org.koin.core.module.Module

fun Module.getGroupByIdModule() {
    single { GetGroupByIdController(get()) }
    single { GetGroupByIdUseCase(get()) }
}