import java.io.FileInputStream
import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("name.remal.check-dependency-updates")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-android")
    id("kotlin-kapt")
}

val keystorePropertiesFile = rootProject.file("keystore.properties")
val keystoreProperties = Properties().apply { load(FileInputStream(keystorePropertiesFile)) }

android {
    compileSdkVersion(Versions.Android.COMPILE_SDK)
    buildToolsVersion(Versions.Android.BUILD_TOOLS)

    defaultConfig {
        applicationId = Versions.Android.DefaultConfig.APPLICATION_ID
        minSdkVersion(Versions.Android.DefaultConfig.MIN_ANDROID_SDK)
        targetSdkVersion(Versions.Android.DefaultConfig.TARGET_ANDROID_SDK)
        versionCode = Versions.Android.DefaultConfig.VERSION_CODE
        versionName = Versions.Android.DefaultConfig.VERSION_NAME
        vectorDrawables.useSupportLibrary = true
        renderscriptTargetApi = Versions.Android.DefaultConfig.MIN_ANDROID_SDK
        renderscriptNdkModeEnabled = true
        multiDexEnabled = true
        testInstrumentationRunner = Versions.Android.DefaultConfig.TEST_INSTRUMENTATION_RUNNER

        ndk {
            abiFilters += listOf("x86", "x86_64", "armeabi", "armeabi-v7a", "arm64-v8a")
        }
    }

    signingConfigs {
        create("release") {
            storeFile(file(keystoreProperties["storeFile"] ?: ""))
            keyAlias(keystoreProperties["keyAlias"] as String?)
            keyPassword(keystoreProperties["keyPassword"] as String?)
            storePassword(keystoreProperties["storePassword"] as String?)
        }
    }

    buildTypes {
        getByName(Versions.Android.BuildTypes.DEBUG) {
            isDebuggable = true
            isMinifyEnabled = false
        }
        getByName(Versions.Android.BuildTypes.RELEASE) {
            signingConfig = signingConfigs.getByName("release")
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        bundle {
            density { enableSplit = true }
            abi { enableSplit = true }
        }
    }

    buildTypes.onEach {
        it.buildConfigField("String", "API_KEY", "${keystoreProperties["apiKey"] as String?}")
        it.buildConfigField("String", "BASE_URL", "${keystoreProperties["BASE_URL"] as String?}")
        it.buildConfigField("String", "YOUTUBE_API", "${keystoreProperties["YOUTUBE_API"] as String?}")
    }

    buildFeatures {
        dataBinding = true
    }

/*
    buildTypes.onEach {
        it.buildConfigField("String", "API_KEY", "\"your-tmdb-api-key\"")
        it.buildConfigField("String", "YOUTUBE_API", "\"your-google-api-key\"")
        it.buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
    }
*/

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    lintOptions {
        isWarningsAsErrors = true
        isAbortOnError = false
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-Xinline-classes",
            "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            "-Xopt-in=kotlinx.coroutines.ObsoleteCoroutinesApi",
            "-Xopt-in=kotlinx.coroutines.FlowPreview",
            "-Xopt-in=org.koin.core.component.KoinApiExtension",
            "-Xallow-result-return-type",
            "-Xopt-in=kotlin.RequiresOptIn"
        )
    }
/*

    configurations.all() {
        resolutionStrategy.force ("org.antlr:antlr4-runtime:4.5.3")
        resolutionStrategy.force ("org.antlr:antlr4-tool:4.5.3")
    }
*/

    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }

    sourceSets["main"].java {
        srcDir("src/sharedTest/java")
    }

    applicationVariants.all {
        val appName: String = if (project.hasProperty("applicationName")) {
            project.property("applicationName") as String
        } else {
            parent?.name ?: "no_app_name"
        }

        outputs
            .map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }
            .forEach { output ->
                output.outputFileName = when {
                    name.contains("release") -> "$appName-v$versionName($versionCode).apk"
                    else -> "${appName}_unknown.apk"
                }
            }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    kotlin()
    coroutines()
    google()
    firebase()
    square()
    rxjava()
    room()
    glide()
    others()
    test()
}