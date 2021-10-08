import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32" apply false
    id("org.springframework.boot") version "2.4.9" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
    kotlin("kapt") version "1.4.32" apply false
    kotlin("plugin.spring") version "1.4.32" apply false
}

allprojects {
    group = "com.sumwhy"
    version = "1.0.14"

    tasks.withType<JavaCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

}

subprojects {

    repositories {
        maven {
            isAllowInsecureProtocol = true
            url = uri("http://115.231.104.66:8888/repository/maven-public/")
        }
        mavenCentral()
    }

    apply {
        plugin("io.spring.dependency-management")
    }
}