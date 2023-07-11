import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.ScriptHandlerScope

val ScriptHandlerScope.classpathDependencies: DependencyHandlerScope.() -> Unit
    get() = {
        classpath(`android-gradle-plugin`)
        classpath(`koin-gradle-plugin`)
        classpath(`kotlin-gradle-plugin`)
        classpath(`navigation-plugin`)
        classpath(`oss-licenses-plugin`)
    }