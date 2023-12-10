plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "com.github.goomon"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.mockk:mockk:1.13.8")
    testImplementation("io.kotest:kotest-assertions-core:5.8.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
    systemProperty("io.mockk.classdump.path", "output")
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}