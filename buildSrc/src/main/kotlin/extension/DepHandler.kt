package extension

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
import Deps
import TestDeps
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

/*
* Adds required dependencies to app module
* */
fun DependencyHandler.appDeps() {

    implementation(Deps.Google.material)
    implementation(Deps.AndroidX.coreKtx)
    implementation(Deps.AndroidX.appcompat)
    implementation(Deps.AndroidX.Constraint.constraintLayout)
    implementation(Deps.AndroidX.Splash.splashScreen)
    implementation(Deps.AndroidX.pagingRuntime)
    implementation(Deps.AndroidX.multiDex)

    // Navigation
    implementation(Deps.AndroidX.Navigation.ui)
    implementation(Deps.AndroidX.Navigation.fragment)

    // Lifecycle
    implementation(Deps.AndroidX.Lifecycle.runtime)
    implementation(Deps.AndroidX.Lifecycle.liveData)
    implementation(Deps.AndroidX.Lifecycle.viewModel)

    // Coroutines
    implementation(Deps.Coroutines.core)
    implementation(Deps.Coroutines.android)

    // Hilt
    implementation(Deps.Dagger.hiltAndroid)
    kapt(Deps.Dagger.hiltCompiler)

    // Timber logger
    implementation(Deps.Timber.timber)

    // Retrofit
    implementation(Deps.Retrofit.retrofit)
    implementation(Deps.Retrofit.retrofitConverter)

    // Moshi
    implementation(Deps.Moshi.moshi)
    kapt(Deps.Moshi.moshiCodegen)

    // OkHttp
    implementation(Deps.OkHttp.okhttp)
    implementation(Deps.OkHttp.logging)

    // Room
    implementation(Deps.AndroidX.Room.runtime)
    implementation(Deps.AndroidX.Room.ktx)
    kapt(Deps.AndroidX.Room.compiler)
    implementation(Deps.AndroidX.Room.room_paging)

    // Intuit
    implementation(Deps.Intuit.ssp)
    implementation(Deps.Intuit.sdp)

    // Coil
    implementation(Deps.Coil.coil)

    // Others
    implementation(Deps.powerSpinner)
    implementation(Deps.youtubePlayer)
}

/*
* Add Unit test dependencies
* */
fun DependencyHandler.unitTestDeps() {
    // (Required) writing and executing Unit Tests on the JUnit Platform
    testImplementation(TestDeps.JUnit.junit)

    // AndroidX Test - JVM testing
    testImplementation(TestDeps.AndroidX.coreKtx)

    // AndroidX Core Testing
    testImplementation(TestDeps.AndroidX.coreTesting)

    // Coroutines Test
    testImplementation(TestDeps.Coroutines.coroutines)

    // MockWebServer
    testImplementation(TestDeps.MockWebServer.mockwebserver)

    // Mockito
    testImplementation(TestDeps.Mockito.core)

    // MocKK
    testImplementation(TestDeps.MockK.mockK)

    // Truth
    testImplementation(TestDeps.truth)

    // Room
    testImplementation(TestDeps.AndroidX.room)
}

/*
* Add Instrumentation test dependencies
* */
fun DependencyHandler.androidTestDeps() {
    // AndroidX Test - Instrumented testing
    androidTestImplementation(TestDeps.AndroidX.androidX_jUnit)
    androidTestImplementation(TestDeps.AndroidX.coreTesting)

    // Espresso
    androidTestImplementation(TestDeps.espressoCore)

    // Navigation Testing
    androidTestImplementation(TestDeps.AndroidX.navigationTest)

    // Coroutines Test
    androidTestImplementation(TestDeps.Coroutines.coroutines)

    // MockWebServer
    androidTestImplementation(TestDeps.MockWebServer.mockwebserver)

    // Mockito
    androidTestImplementation(TestDeps.Mockito.core)
    androidTestImplementation(TestDeps.Mockito.android)

    // MockK
    androidTestImplementation(TestDeps.MockK.mockK)

    // Truth
    androidTestImplementation(TestDeps.truth)
}

/*
 * These extensions mimic the extensions that are generated on the fly by Gradle.
 * They are used here to provide above dependency syntax that mimics Gradle Kotlin DSL
 * syntax in module\build.gradle.kts files.
 */
private fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

private fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

private fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

private fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

private fun DependencyHandler.testRuntimeOnly(dependencyNotation: Any): Dependency? =
    add("testRuntimeOnly", dependencyNotation)

private fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)
