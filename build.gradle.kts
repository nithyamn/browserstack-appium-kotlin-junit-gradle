import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.seleniumhq.selenium:selenium-java:4.8.1")
    implementation("io.appium:java-client:8.5.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    compileOnly("com.browserstack:browserstack-java-sdk:latest.release")
}
val browserstackSDKArtifact = configurations.compileClasspath.get().resolvedConfiguration.resolvedArtifacts.find { it.name == "browserstack-java-sdk" }

tasks.test {
    useJUnitPlatform(){
        jvmArgs("-javaagent:${browserstackSDKArtifact?.file}")
    }
    filter{
        includeTestsMatching("*SearchTest")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}