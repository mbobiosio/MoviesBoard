plugins {
    id ("com.android.application")
    kotlin("android")
    kotlin("kapt")
    //id("kotlin-android-extensions")
    id("name.remal.check-dependency-updates")
    //id("kotlin-android")
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
            //buildConfigField("String", "BASE_URL", "\"https://restcountries.eu/rest/v2/\"")
            buildConfigField("String", "API_KEY", "\"1238d2a97622a6767443621fe24e29eb\"")
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
            buildConfigField("String", "YOUTUBE_API", "\"AIzaSyA2GusEVzh3t8_uRTlL1E1cH5vjOdFyHNU\"")
        }
        getByName(Versions.Android.BuildTypes.RELEASE) {
            isMinifyEnabled = false
            buildConfigField("String", "API_KEY", "\"1238d2a97622a6767443621fe24e29eb\"")
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
            buildConfigField("String", "YOUTUBE_API", "\"AIzaSyA2GusEVzh3t8_uRTlL1E1cH5vjOdFyHNU\"")
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
    //implementation("androidx.appcompat:appcompat:1.2.0")
    //implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    //implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    //implementation (files("libs\\YouTubeAndroidPlayerApi.jar"))
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