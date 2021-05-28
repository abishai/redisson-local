plugins {
    kotlin("jvm") version "1.4.32"
}

object Version {
    const val redisson = "3.15.5"
    const val junit = "5.7.0"
}


group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.redisson:redisson:${Version.redisson}") {
        exclude(group = "io.reactivex.rxjava3", module = "rxjava")
        exclude(group = "io.projectreactor", module = "reactor-core")
    }
}
