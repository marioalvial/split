package io.github.marioalvial.split.user.usecases.createuser

import io.github.marioalvial.split.user.usecases.createuser.application.CreateUserController
import io.github.marioalvial.split.user.usecases.createuser.core.CreateUserUseCase
import io.github.marioalvial.split.user.usecases.createuser.core.ports.CryptService
import io.github.marioalvial.split.user.usecases.createuser.infra.adapters.CryptServiceAdapter
import org.koin.core.module.Module

fun Module.createUserModule() {
    single { CreateUserController(get()) }
    single { CreateUserUseCase(get(), get()) }
    single<CryptService> { CryptServiceAdapter() }
}