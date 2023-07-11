buildscript {
    repositories(repos)
    dependencies(classpathDependencies)
}

plugins {
    `android-application` version `android-gradle-plugin version` apply false
    `android-library` version `android-gradle-plugin version` apply false
    `kotlin-android` version `kotlin version` apply false
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}