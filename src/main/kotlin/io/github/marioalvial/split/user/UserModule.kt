package io.github.marioalvial.split.user

import io.github.marioalvial.split.user.usecases.createuser.createUserModule
import io.github.marioalvial.split.user.usecases.getuserbyid.getUserByIdModule
import io.github.marioalvial.split.user.usecases.listusers.listUsersModule
import io.github.marioalvial.split.user.usecases.shared.core.ports.UserRepository
import io.github.marioalvial.split.user.usecases.shared.infra.adapters.UserRepositoryAdapter
import org.koin.dsl.module

val userModule = module {
    single<UserRepository> { UserRepositoryAdapter() }
    createUserModule()
    listUsersModule()
    getUserByIdModule()
}