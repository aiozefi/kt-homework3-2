plugins {
    kotlin("jvm") version "1.9.22"
    jacoco
    application
}

group = "ru.netology"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin ("test"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation("junit:junit:4.13.2")
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}