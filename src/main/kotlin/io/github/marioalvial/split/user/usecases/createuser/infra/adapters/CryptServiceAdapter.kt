package io.github.marioalvial.split.user.usecases.createuser.infra.adapters

import at.favre.lib.crypto.bcrypt.BCrypt
import io.github.marioalvial.split.user.usecases.createuser.core.ports.CryptService

class CryptServiceAdapter : CryptService {

    override fun encrypt(value: String): String = BCrypt.withDefaults().hashToString(12, value.toCharArray())
}