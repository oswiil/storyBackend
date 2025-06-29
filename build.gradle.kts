plugins {
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "2.1.21"
    kotlin("plugin.spring") version "2.1.21"
    kotlin("plugin.jpa") version "2.1.21"
}

group = "org.example"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_21

repositories {
    mavenCentral()
}

dependencies {
    // Spring Web + REST
    implementation("org.springframework.boot:spring-boot-starter-web")

    // JPA + PostgreSQL
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.postgresql:postgresql")

    // Jackson for Kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Kotlin standard libs
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")

    // OpenAPI / Swagger (Springdoc)
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")

    // Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}
