package no.home
import org.gradle.api.Plugin
import org.gradle.api.Project

class GreetingPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        println(" tadaa from plugin")
        val extension = target.extensions.create("greetingExtension",GreetingPluginExtension::class.java)
        target.tasks.register("greetingTask",GreetingTask::class.java){
            it.greeting = extension.greeter.get()
        }
        //println("greinting plugin registered greeting task with variale ${extension.greeter.get()}")
    }
}
