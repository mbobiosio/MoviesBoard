import extension.androidTestDeps
import extension.appDeps
import extension.unitTestDeps
import java.io.FileInputStream
import java.util.*

plugins {
    id(Plugins.ANDROID_APPLICATION)
    kotlin(Plugins.ANDROID)
    kotlin(Plugins.KAPT)
    id(Plugins.PARCELIZE)
    id(Plugins.DAGGER_HILT)
    id(Plugins.NAVIGATION_SAFE_ARGS)
}

val keystorePropertiesFile = rootProject.file("keystore.properties")
val keystoreProperties = Properties().apply { load(FileInputStream(keystorePropertiesFile)) }

android {
    compileSdk = AndroidConfigs.COMPILE_SDK

    defaultConfig {
        applicationId = AndroidConfigs.APPLICATION_ID
        minSdk = AndroidConfigs.MIN_SDK
        targetSdk = AndroidConfigs.TARGET_SDK
        versionCode = AndroidConfigs.VERSION_CODE
        versionName = AndroidConfigs.VERSION_NAME
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
        testInstrumentationRunner = AndroidConfigs.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName(Versions.Android.BuildTypes.DEBUG) {
            isDebuggable = true
            isMinifyEnabled = false
        }
        getByName(Versions.Android.BuildTypes.RELEASE) {
            // signingConfig = signingConfigs.getByName("release")
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
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

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    packagingOptions {
        resources.excludes += setOf(
            "META-INF/AL2.0",
            "META-INF/LGPL2.1"
        )
    }

    sourceSets["main"].java {
        srcDir("src/sharedTest/java")
    }
}

dependencies {

    // Required dependencies
    appDeps()

    // Unit test dependencies
    unitTestDeps()

    // Android testing dependencies
    androidTestDeps()
}
