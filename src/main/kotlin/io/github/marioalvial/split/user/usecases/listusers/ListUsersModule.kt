package io.github.marioalvial.split.user.usecases.listusers

import io.github.marioalvial.split.user.usecases.listusers.application.ListUsersController
import io.github.marioalvial.split.user.usecases.listusers.core.ListUsersUseCase
import org.koin.core.module.Module

fun Module.listUsersModule() {
    single { ListUsersController(get()) }
    single { ListUsersUseCase(get()) }
}