package no.home

import org.gradle.api.provider.Property

//https://docs.gradle.org/current/userguide/custom_plugins.html
//https://docs.gradle.org/current/userguide/init_scripts.html
interface GreetingPluginExtension {
    val message: Property<String>
    val greeter: Property<String>
    val projectID: Property<String>
    val shouldPublish: Property<Boolean>
    val excludes: Property<List<String>>
}
