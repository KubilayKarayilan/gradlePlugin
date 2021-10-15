package no.home

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

abstract class GreetingTask: DefaultTask() {
    @Input
    abstract fun getProjectId():Property<String>

    @TaskAction
    fun printProjectId() {
        println("Hello from task"+getProjectId().get())
    }
}
