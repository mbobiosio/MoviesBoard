plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("name.remal.check-dependency-updates")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Versions.Android.COMPILE_SDK)
    buildToolsVersion = Versions.Android.BUILD_TOOLS

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
    }

    buildTypes {
        getByName(Versions.Android.BuildTypes.DEBUG) {
            buildConfigField("String", "API_KEY", "\"your-tmdb-api-key\"")
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
            buildConfigField("String", "YOUTUBE_API", "\"your-google-api-key\"")
        }
        getByName(Versions.Android.BuildTypes.RELEASE) {
            isMinifyEnabled = false
            buildConfigField("String", "API_KEY", "\"your-tmdb-api-key\"")
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
            buildConfigField("String", "YOUTUBE_API", "\"your-google-api-key\"")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        dataBinding = true
    }

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
            "-Xopt-in=org.koin.core.component.KoinApiExtension"
        )
    }

    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }

    sourceSets["main"].java {
        srcDir("src/sharedTest/java")
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
    glide()
    others()
    test()
}