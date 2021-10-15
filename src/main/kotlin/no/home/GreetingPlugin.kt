package no.home
import org.gradle.api.Plugin
import org.gradle.api.Project

class GreetingPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        println(" tadaa beeach")
        target.tasks.register("greetingTask",GreetingTask::class.java)
    }
}
