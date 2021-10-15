import org.jetbrains.kotlin.fir.resolve.dfa.contracts.createArgumentsMapping

plugins {
    `java-gradle-plugin`
    `maven-publish`
    id("com.gradle.plugin-publish") version "0.16.0"
    kotlin("jvm") version "1.5.21"
}

group = "no.home"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

pluginBundle {
    website = "https://www.kubilayka.com/"
    vcsUrl = "https://github.com/kubilayka"
    tags = listOf("home","test","greeting","plugins")
}
gradlePlugin{
    plugins {
        create("simplePlugin"){
            id = "no.home.gplugin"
            displayName = "test plugin"
            description = "this is my first plugin published"
            implementationClass = "no.home.GreetingPlugin"
        }
    }
}
