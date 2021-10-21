package no.home

import org.gradle.api.provider.Property
//https://docs.gradle.org/current/userguide/custom_plugins.html
interface GreetingPluginExtension {
    val message: Property<String>
    val greeter: Property<String>
}
