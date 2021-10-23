plugins {
    `java-gradle-plugin`
    `maven-publish`
    id("com.gradle.plugin-publish") version "0.16.0"
    id("org.gradle.kotlin.kotlin-dsl") version "1.4.9"
    kotlin("jvm") version "1.5.21"
}

group = "no.home"
version = "1.7"

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
    vcsUrl = "https://github.com/KubilayKarayilan/gradlePlugin"
    tags = listOf("home", "test", "greeting", "plugins")
}
gradlePlugin {
    plugins {
        create("greetingPlugin") {
            id = "greetingPlugin"
            displayName = "test plugin"
            description = "this is my first plugin published"
            implementationClass = "no.home.GreetingPlugin"
            group = "no.home.greeting"
        }
    }
}
publishing {
    repositories {
        mavenLocal()
    }
}
