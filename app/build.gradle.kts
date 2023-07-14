import java.util.Properties

plugins {
    `android-application`
    `kotlin-android`
    `kotlin-kapt`
    `android-navigation`
    `oss-licenses`
}

android {
    namespace = "ch.lock.mobile.android.deviceinfo"
    compileSdk = DeviceInfo.compileSdk

    defaultConfig {
        applicationId = "ch.lock.mobile.android.deviceinfo"
        minSdk = DeviceInfo.minSdk
        targetSdk = DeviceInfo.targetSdk
        versionCode = DeviceInfo.versionCode
        versionName = DeviceInfo.versionName

        testInstrumentationRunner = DeviceInfo.androidTestInstrumentation
    }

    signingConfigs {
        create("keystore") {
            val keystoreProperties = loadKeystore(file("./keystore/keystore.properties"))

            storeFile = file(keystoreProperties["storeFile"] as String)
            storePassword = keystoreProperties["storePassword"] as String
            keyAlias = keystoreProperties["keyAlias"] as String
            keyPassword = keystoreProperties["keyPassword"] as String
        }
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
            isZipAlignEnabled = false
            isShrinkResources = false
            aaptOptions.cruncherEnabled = false

            versionNameSuffix = "-dbg"
            applicationIdSuffix = ".dbg"

            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            isZipAlignEnabled = true
            isShrinkResources = true
            aaptOptions.cruncherEnabled = true

            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }
    buildFeatures {
        compose = true
        dataBinding = true
    }
    kapt {
        generateStubs = true
    }
    lintOptions {
        isAbortOnError = false
        isCheckReleaseBuilds = false
    }
    buildFeatures {
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.1"
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
}

fun loadKeystore(propertiesFile: File) = Properties().apply {
    propertiesFile.inputStream().use { fis ->
        load(fis)
    }
}

dependencies {

    `ktx`
    `appcompat`
    `material`
    `constraint-layout`

    `compose ui`
    `compose preview`
    `compose material`
    `compose activity`

    `compose-ui-junit`
    `compose-ui-tooling`
    `compose-manifest`

    `coroutines-android`
    `coroutines-rx3`

    `datastore-pref`

    `koin-core`
    `koin-android`
    `koin-compose`
    `koin-test`

    `navigation-fragment`
    `navigation-runtime`
    `navigation-ui`

    `leakcanary`

    `lifecycle-livedata`
    `lifecycle-runtime`
    `lifecycle-viewmodel`
    `lifecycle-viewmodel-savedstate`
    `lifecycle-common`

    `play-service-oss-licenses`

    `ted-activity-result`
    `ted-permission`

    `rx-android`
    `rx-kotlin`
    `rx3-bridge`

    `junit`
    `android-junit`
    `espresso`

}