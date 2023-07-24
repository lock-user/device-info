import org.gradle.api.artifacts.dsl.DependencyHandler

// Classpath
val DependencyHandler.`android-gradle-plugin` get() = "com.android.tools.build:gradle:${`android-gradle-plugin version`}"
val DependencyHandler.`koin-gradle-plugin` get() = "io.insert-koin:koin-gradle-plugin:${`koin version`}"
val DependencyHandler.`kotlin-gradle-plugin` get() = "org.jetbrains.kotlin:kotlin-gradle-plugin:${`kotlin version`}"
val DependencyHandler.`navigation-plugin` get() = "androidx.navigation:navigation-safe-args-gradle-plugin:${`navigation version`}"
val DependencyHandler.`oss-licenses-plugin` get() = "com.google.android.gms:oss-licenses-plugin:${`oss-licenses-plugin version`}"

// Android Support
val DependencyHandler.`appcompat` get() = implementation("androidx.appcompat:appcompat:${`appcompat version`}")
val DependencyHandler.`constraint-layout` get() = implementation("androidx.constraintlayout:constraintlayout:${`constraint-layout version`}")
val DependencyHandler.`material` get() = implementation("com.google.android.material:material:${`material version`}")
val DependencyHandler.`ktx` get() = implementation("androidx.core:core-ktx:${`ktx version`}")

// Compose
val DependencyHandler.`compose ui` get() = implementation("androidx.compose.ui:ui:${`compose version`}")
val DependencyHandler.`compose preview` get() = implementation("androidx.compose.ui:ui-tooling-preview:${`compose version`}")
val DependencyHandler.`compose material3` get() = implementation("androidx.compose.material3:material3:${`compose-material3 version`}")
val DependencyHandler.`compose activity` get() = implementation("androidx.activity:activity-compose:${`compose-activity version`}")

// Compose Test
val DependencyHandler.`compose-ui-junit` get() = androidTestImplementation("androidx.compose.ui:ui-test-junit4:${`compose version`}")
val DependencyHandler.`compose-ui-tooling` get() = debugImplementation("androidx.compose.ui:ui-tooling:${`compose version`}")
val DependencyHandler.`compose-manifest` get() = debugImplementation("androidx.compose.ui:ui-test-manifest:${`compose version`}")

// Coroutines
val DependencyHandler.`coroutines-android` get() = implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${`coroutines version`}")
val DependencyHandler.`coroutines-rx3` get() = implementation("org.jetbrains.kotlinx:kotlinx-coroutines-rx3:${`coroutines version`}")

// DataStore
val DependencyHandler.`datastore-pref` get() = implementation("androidx.datastore:datastore-preferences:${`datastore-pref version`}")

// DI
val DependencyHandler.`koin-core` get() = implementation("io.insert-koin:koin-core:${`koin version`}")
val DependencyHandler.`koin-android` get() = implementation("io.insert-koin:koin-android:${`koin version`}")
val DependencyHandler.`koin-compose` get() = implementation("io.insert-koin:koin-androidx-compose:${`koin version`}")
val DependencyHandler.`koin-test` get() = testImplementation("io.insert-koin:koin-test:${`koin version`}")

// LeakCanary
val DependencyHandler.`leakcanary` get() = debugImplementation("com.squareup.leakcanary:leakcanary-android:${`leakcanary version`}")

// Lifecycle Components
val DependencyHandler.`lifecycle-livedata` get() = implementation("androidx.lifecycle:lifecycle-livedata-ktx:${`lifecycle version`}")
val DependencyHandler.`lifecycle-runtime` get() = implementation("androidx.lifecycle:lifecycle-runtime-ktx:${`lifecycle version`}")
val DependencyHandler.`lifecycle-viewmodel` get() = implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${`lifecycle version`}")
val DependencyHandler.`lifecycle-viewmodel-savedstate` get() = implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:${`lifecycle version`}")
val DependencyHandler.`lifecycle-common` get() = implementation("androidx.lifecycle:lifecycle-common-java8:${`lifecycle version`}")

// Logger
val DependencyHandler.`square-logcat` get() = implementation("com.squareup.logcat:logcat:${`square-logcat version`}")

// Navigation
val DependencyHandler.`navigation-fragment` get() = implementation("androidx.navigation:navigation-fragment-ktx:${`navigation version`}")
val DependencyHandler.`navigation-runtime` get() = implementation("androidx.navigation:navigation-runtime-ktx:${`navigation version`}")
val DependencyHandler.`navigation-ui` get() = implementation("androidx.navigation:navigation-ui-ktx:${`navigation version`}")

// OSS Licenses Plugin
val DependencyHandler.`play-service-oss-licenses` get() = implementation("com.google.android.gms:play-services-oss-licenses:${`play-service-oss-licenses-plugin version`}")

// Permission
val DependencyHandler.`ted-activity-result` get() = implementation("io.github.ParkSangGwon:tedonactivityresult-rx2:${`ted-activity-result version`}")
val DependencyHandler.`ted-permission` get() = implementation("io.github.ParkSangGwon:tedpermission-coroutine:${`ted-permission version`}")

// ReactiveX
val DependencyHandler.`rx-android` get() = implementation("io.reactivex.rxjava3:rxandroid:${`rx-android version`}")
val DependencyHandler.`rx-kotlin` get() = implementation("io.reactivex.rxjava3:rxkotlin:${`rx-kotlin version`}")
val DependencyHandler.`rx3-bridge` get() = implementation("com.github.akarnokd:rxjava3-bridge:${`rx3-bridge version`}")

// Test
val DependencyHandler.`junit` get() = testImplementation("junit:junit:${`junit version`}")
val DependencyHandler.`android-junit` get() = androidTestImplementation("androidx.test.ext:junit:${`android-junit version`}")
val DependencyHandler.`espresso` get() = androidTestImplementation("androidx.test.espresso:espresso-core:${`espresso version`}")

fun DependencyHandler.androidTestImplementation(dependency: String) {
    add("androidTestImplementation", dependency)
}

fun DependencyHandler.debugImplementation(dependency: String) {
    add("debugImplementation", dependency)
}

fun DependencyHandler.implementation(dependency: String) {
    add("implementation", dependency)
}

fun DependencyHandler.kapt(dependency: String) {
    add("kapt", dependency)
}

fun DependencyHandler.testImplementation(dependency: String) {
    add("testImplementation", dependency)
}