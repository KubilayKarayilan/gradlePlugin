package no.home

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

abstract class GreetingTask: DefaultTask() {


    var greeting = "default string"

    @TaskAction
    fun printProjectId() {
        println("Hello from task ${greeting}")
    }
}
