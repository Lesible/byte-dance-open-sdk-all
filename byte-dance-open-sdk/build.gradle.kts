plugins {
    kotlin("jvm")
    id("org.springframework.boot")
    kotlin("kapt")
    kotlin("plugin.spring")
    id("org.jetbrains.dokka") version "1.5.0"
    `java-library`
    `maven-publish`
}

java {
    withSourcesJar()
}

tasks.dokkaHtml.configure {
    outputDirectory.set(buildDir.resolve("dokka"))
}

tasks.getByName<Jar>("jar") {
    enabled = true
}

val dokkaHtml by tasks.getting(org.jetbrains.dokka.gradle.DokkaTask::class)

val javadocJar: TaskProvider<Jar> by tasks.registering(Jar::class) {
    dependsOn(dokkaHtml)
    archiveClassifier.set("javadoc")
    from(dokkaHtml.outputDirectory)
}

group = "com.sumwhy"
version = "1.0.5"
java.sourceCompatibility = JavaVersion.VERSION_1_8

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "byte-dance-open-sdk"
            from(components["java"])
            artifact(javadocJar)
        }
    }
    repositories {
        maven {
            val release = uri("http://115.231.104.66:8888/repository/maven-releases/")
            val snapshot = uri("http://115.231.104.66:8888/repository/maven-snapshots/")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshot else release
            credentials {
                username = "admin"
                password = "qwer1234"
            }
        }
    }
}

dependencies {
    kapt("org.springframework.boot:spring-boot-configuration-processor")
    api("com.squareup.retrofit2:retrofit:2.7.2")
    api("com.squareup.retrofit2:converter-scalars:2.7.2")
    api("com.squareup.retrofit2:converter-jackson:2.7.2") {
        exclude(group = "com.fasterxml.jackson.core", module = "jackson-databind")
    }
    api("org.jetbrains.kotlin:kotlin-reflect")
    api("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    api("commons-codec:commons-codec:1.15")
    api("org.apache.commons:commons-lang3:3.12.0")
    api("org.slf4j:slf4j-api:1.7.32")
    api("com.squareup.okhttp3:logging-interceptor:3.14.7")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    compileOnly("org.springframework.boot:spring-boot-starter")
    compileOnly("org.springframework.boot:spring-boot-starter-web")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}
