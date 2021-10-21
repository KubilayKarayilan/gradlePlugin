package no.home

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

abstract class GreetingTask: DefaultTask() {

    @set:Input
    var greeting = "default string"


    @TaskAction
    fun printProjectId() {
        println("Hello from task ${greeting}")
    }
}
