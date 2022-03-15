package io.github.marioalvial.split.group.usecases.addusertogroup

import io.github.marioalvial.split.group.usecases.addusertogroup.application.AddUserToGroupController
import io.github.marioalvial.split.group.usecases.addusertogroup.core.AddUserToGroupUseCase
import org.koin.core.module.Module

fun Module.addUserToGroupModule(){
    single { AddUserToGroupController(get()) }
    single { AddUserToGroupUseCase(get(), get()) }
}