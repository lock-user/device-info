import org.gradle.api.artifacts.dsl.RepositoryHandler

val repos: RepositoryHandler.() -> Unit
    get() = {
        google()
        gradlePluginPortal()
        mavenCentral()
    }