import extension.androidTestDeps
import extension.domainDeps
import extension.unitTestDeps

plugins {
    id(Plugins.ANDROID_LIBRARY)
    kotlin(Plugins.ANDROID)
    kotlin(Plugins.KAPT)
    id(Plugins.PARCELIZE)
}

android {
    compileSdk = AndroidConfigs.COMPILE_SDK

    defaultConfig {
        minSdk = AndroidConfigs.MIN_SDK
        targetSdk = AndroidConfigs.TARGET_SDK

        testInstrumentationRunner = AndroidConfigs.TEST_INSTRUMENTATION_RUNNER
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {

    // Domain module dependencies
    domainDeps()

    // Unit test dependencies
    unitTestDeps()

    // Android test dependencies
    androidTestDeps()
}
