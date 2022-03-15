package io.github.marioalvial.split.group.usecases.creategroup.core

import kotlinx.serialization.Serializable

@Serializable
class CreateGroupInput(
    val name: String,
    val ownerId: String
) : java.io.Serializable