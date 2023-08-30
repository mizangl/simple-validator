plugins {
    kotlin("jvm") version "1.9.0"
}

group = "mz.validator"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.jetbrains.kotlin:kotlin-reflect:1.8.0")

    testImplementation("io.kotest:kotest-assertions-core:5.6.2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}