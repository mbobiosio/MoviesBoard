import extension.androidTestDeps
import extension.coreDeps
import extension.unitTestDeps
import java.io.FileInputStream
import java.util.*

plugins {
    id(Plugins.ANDROID_LIBRARY)
    kotlin(Plugins.ANDROID)
    kotlin(Plugins.KAPT)
}

val keystorePropertiesFile = rootProject.file("keystore.properties")
val keystoreProperties = Properties().apply { load(FileInputStream(keystorePropertiesFile)) }

android {
    compileSdk = AndroidConfigs.COMPILE_SDK

    defaultConfig {
        minSdk = AndroidConfigs.MIN_SDK
        targetSdk = AndroidConfigs.TARGET_SDK

        testInstrumentationRunner = AndroidConfigs.TEST_INSTRUMENTATION_RUNNER
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildTypes.onEach {
        it.buildConfigField("String", "API_KEY", "${keystoreProperties["apiKey"] as String?}")
        it.buildConfigField("String", "BASE_URL", "${keystoreProperties["BASE_URL"] as String?}")
        it.buildConfigField(
            "String",
            "YOUTUBE_API",
            "${keystoreProperties["YOUTUBE_API"] as String?}"
        )
    }

    android.buildFeatures.dataBinding = true

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {

    // Required dependencies
    coreDeps()

    // Unit test dependencies
    unitTestDeps()

    // Android test dependencies
    androidTestDeps()
}
