package io.github.marioalvial.split.user.usecases.createuser.core.ports

interface CryptService {

    fun encrypt(value: String): String
}