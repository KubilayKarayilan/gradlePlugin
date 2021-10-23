package no.home

import org.gradle.api.DefaultTask
import org.gradle.api.artifacts.repositories.MavenArtifactRepository
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.tasks.TaskAction
import java.net.URI

abstract class GreetingTask: DefaultTask() {


    var greeting = "default string"
    var projectID = "doesNotExists1"
    var shouldPublish = false

    @TaskAction
    fun printProjectId() {
        println("Hello from task ${greeting}")
        // Publish to Gitlab
        if (shouldPublish) {
            println("publish is true ***************")
            project.extensions.getByType(PublishingExtension::class.java).repositories {
                this.maven {
                    url = URI.create("https://gitlab.com/api/v4/projects/$projectID/packages/maven").also {
                        println(it)
                    }
                    this.gitLabCredentials(project)
                }
            }
        }
    }
}
