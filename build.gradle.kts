import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    application
}

group = "com.github.leafylappa"
version = "1.0"

repositories {
    mavenCentral()
    maven {
        url = uri("https://us-central1-maven.pkg.dev/varabyte-repos/public")
    }
}

dependencies {
    implementation("io.insert-koin:koin-core:3.2.0-beta-1")
    implementation("com.varabyte.kotter:kotter:0.9.7")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")

    testImplementation(kotlin("test"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClass.set("MainKt")
}