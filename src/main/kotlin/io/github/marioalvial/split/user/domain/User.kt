package io.github.marioalvial.split.user.domain

import java.util.UUID

class User(
    val id: UUID,
    val name: String,
    val email: String,
    val password: String,
    val sequentialId: Int? = null
)