package io.github.marioalvial.split.user.usecases.getuserbyid

import io.github.marioalvial.split.user.usecases.getuserbyid.core.GetUserByIdUseCase
import org.koin.core.module.Module

fun Module.getUserByIdModule() {
    single { GetUserByIdUseCase(get()) }
}