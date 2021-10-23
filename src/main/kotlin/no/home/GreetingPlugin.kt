package no.home

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.repositories.MavenArtifactRepository
import org.gradle.api.credentials.HttpHeaderCredentials
import org.gradle.authentication.http.HttpHeaderAuthentication
import org.gradle.kotlin.dsl.create
import java.net.URI

class GreetingPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        //Create extension to pass arguments from project
        val extension = project.extensions.create("greetingExtension", GreetingPluginExtension::class.java)
        // Register task and pass some args
        project.tasks.register("greetingTask", GreetingTask::class.java) {
            println("in task register")
            greeting = extension.greeter.get()
            projectID = extension.projectID.get()
            shouldPublish = extension.shouldPublish.get()
            println("task register done ")
        }

        // Add gitlab repo
        project.repositories.maven {
            url = URI.create("https://gitlab.com/api/v4/groups/6569239/-/packages/maven")
            gitLabCredentials(project)
        }
        println("add dependency....")
        // Add some dependency
        project.dependencies.add("implementation", "com.fasterxml.jackson.core:jackson-annotations:2.12.4")
        println("add publish gitlab....")

        println("plugin init done....")
    }
}
fun MavenArtifactRepository.gitLabCredentials(project: Project) {
    credentials(HttpHeaderCredentials::class.java) {
        System.getenv("CI_JOB_TOKEN")?.let {
            name = "Job-Token"
            value = it
            return@credentials
        }
        name = "Private-Token"
        value = project.properties["gitLabPrivateToken"] as String? ?: error(
            "Couldn't find CI_JOB_TOKEN env variable. If locally, set 'gitLabPrivateToken=<gitlab-personal-access-token>' in ~/.gradle/gradle.properties!"
        )
    }
    authentication {
        create<HttpHeaderAuthentication>("header")
    }
}
