plugins {
    kotlin("jvm") version "2.2.20"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.12.2")
}

kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}