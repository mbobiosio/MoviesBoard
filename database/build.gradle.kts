import extension.androidTestDeps
import extension.databaseDeps
import extension.unitTestDeps

plugins {
    id(Plugins.ANDROID_LIBRARY)
    kotlin(Plugins.ANDROID)
    kotlin(Plugins.KAPT)
    id(Plugins.DAGGER_HILT)
}

android {

    compileSdk = AndroidConfigs.COMPILE_SDK

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    namespace = PackageName.database

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
    databaseDeps()

    // Unit test dependencies
    unitTestDeps()

    // Android test dependencies
    androidTestDeps()
}
