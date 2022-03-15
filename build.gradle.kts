plugins {
    application
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.serialization") version "1.6.10"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform(kotlin("bom")))

    // Use the Kotlin JDK 8 standard library.
    implementation(kotlin("stdlib-jdk8"))

    // Web Framework
    implementation("io.ktor:ktor-server-core:1.6.7")
    implementation("io.ktor:ktor-server-netty:1.6.7")
    implementation("io.ktor:ktor-serialization:1.6.7")

    // Dependency Injection
    implementation("io.insert-koin:koin-ktor:3.1.5")

    // Database
    implementation("org.jetbrains.exposed", "exposed-core" , "0.37.3")
    implementation("org.jetbrains.exposed", "exposed-jdbc", "0.37.3")
    implementation("org.jetbrains.exposed", "exposed-dao", "0.37.3")
    implementation("org.flywaydb", "flyway-core", "8.4.0")
    implementation("org.postgresql", "postgresql", "42.3.1")
    implementation("com.zaxxer", "HikariCP", "5.0.0")

    // Encrypt
    implementation("at.favre.lib", "bcrypt", "0.9.0")

    // Logging
    implementation("ch.qos.logback:logback-classic:1.2.10")

    // Use the Kotlin test library.
    testImplementation(kotlin("test"))

    // Use the Kotlin JUnit integration.
    testImplementation(kotlin("test-junit"))


    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.testcontainers:testcontainers:1.16.3")
    testImplementation("org.testcontainers:junit-jupiter:1.16.3")
}
