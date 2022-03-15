package io.github.marioalvial.split.containers

import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.wait.strategy.Wait
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.utility.DockerImageName


object PostgresContainer {

    @Container
    private val postgres: GenericContainer<*> = GenericContainer(DockerImageName.parse("postgres:latest"))
        .withExposedPorts(5434)
        .waitingFor(Wait.forHealthcheck())

    fun start(){
        postgres.start()
    }

    fun stop(){
        postgres.stop()
    }
}

fun main() {
    PostgresContainer.start()
}