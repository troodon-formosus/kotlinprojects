plugins {
    kotlin("jvm") version "1.6.10"
}

group = "dr.clozric.lab"
version = "1.0.0"

repositories {
    maven {
        credentials {
            username = System.getenv("NEXUS_USER")
            password = System.getenv("NEXUS_PASS")
        }
        url = uri("https://nexus.px019.net/repository/maven-central/")
    }
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.assertj:assertj-core:3.21.0")
    implementation(kotlin("stdlib"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}
