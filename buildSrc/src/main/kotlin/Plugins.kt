import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

val PluginDependenciesSpec.`android-application` get() = plugin("com.android.application")
val PluginDependenciesSpec.`android-library` get() = plugin("com.android.library")
val PluginDependenciesSpec.`android-navigation` get() = plugin("androidx.navigation.safeargs.kotlin")
val PluginDependenciesSpec.`kotlin-android` get() = plugin("org.jetbrains.kotlin.android")
val PluginDependenciesSpec.`kotlin-kapt` get() = plugin("kotlin-kapt")
val PluginDependenciesSpec.`oss-licenses` get() = plugin("com.google.android.gms.oss-licenses-plugin")

fun PluginDependenciesSpec.plugin(id: String): PluginDependencySpec = id(id)