package extension

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
import Deps
import Modules
import TestDeps
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler

/*
* Adds required dependencies to app module
* */
fun DependencyHandler.appDeps() {
    implementation(project(Modules.core))
    implementation(project(Modules.domain))
    implementation(project(Modules.database))

    // AndroidX
    implementation(Deps.AndroidX.Splash.splashScreen)
    implementation(Deps.AndroidX.multiDex)

    // Lifecycle
    implementation(Deps.AndroidX.Lifecycle.runtime)
    implementation(Deps.AndroidX.Lifecycle.liveData)
    implementation(Deps.AndroidX.Lifecycle.viewModel)

    implementation(Deps.AndroidX.Room.runtime)
    implementation(Deps.AndroidX.Room.ktx)
    kapt(Deps.AndroidX.Room.compiler)
    implementation(Deps.AndroidX.Room.room_paging)

    // Hilt
    implementation(Deps.Dagger.hiltAndroid)
    kapt(Deps.Dagger.hiltCompiler)

    // Retrofit
    // implementation(Deps.Retrofit.retrofit)
    implementation(Deps.Retrofit.retrofitConverter)

    // Moshi
    kapt(Deps.Moshi.moshiCodegen)

    // OkHttp
    // implementation(Deps.OkHttp.okhttp)
    implementation(Deps.OkHttp.logging)

    // Others
    implementation(Deps.powerSpinner)

    // Material rating bar
    implementation(Deps.materialRatingBar)

    // Coil
    implementation(Deps.Coil.coil)
}

/*
* Add database module dependencies
* */
fun DependencyHandler.databaseDeps() {
    implementation(project(Modules.core))

    // Room
    implementation(Deps.AndroidX.Room.runtime)
    implementation(Deps.AndroidX.Room.ktx)
    kapt(Deps.AndroidX.Room.compiler)
    implementation(Deps.AndroidX.Room.room_paging)

    // Hilt
    implementation(Deps.Dagger.hiltAndroid)
    kapt(Deps.Dagger.hiltCompiler)
}

/*
* Add core module dependencies
* */
fun DependencyHandler.coreDeps() {
    // Google
    api(Deps.Google.material)

    // AndroidX
    api(Deps.AndroidX.coreKtx)
    api(Deps.AndroidX.appcompat)
    api(Deps.AndroidX.Constraint.constraintLayout)
    api(Deps.AndroidX.pagingRuntime)
    implementation(Deps.AndroidX.viewPager2)

    // Coroutines
    api(Deps.Coroutines.core)
    api(Deps.Coroutines.android)

    // Navigation
    api(Deps.AndroidX.Navigation.ui)
    api(Deps.AndroidX.Navigation.fragment)

    // Hilt
    implementation(Deps.Dagger.hiltAndroid)
    kapt(Deps.Dagger.hiltCompiler)

    // OkHttp
    api(Deps.OkHttp.okhttp)

    // Moshi
    api(Deps.Moshi.moshi)
    kapt(Deps.Moshi.moshiCodegen)

    // Retrofit
    api(Deps.Retrofit.retrofit)

    // Intuit
    api(Deps.Intuit.ssp)
    api(Deps.Intuit.sdp)

    // Timber logger
    api(Deps.Timber.timber)

    // Coil
    api(Deps.Coil.coil)

    // Youtube player
    api(Deps.youtubePlayer)

    // Skeleton layout
    api(Deps.skeletonLayout)

    // AndroidVeil
    api(Deps.androidVeil)
}

/*
* Domain module dependencies
* */
fun DependencyHandler.domainDeps() {
    // Modules
    implementation(project(Modules.core))

    // Google
    implementation(Deps.Google.material)

    // Coroutines
    implementation(Deps.Coroutines.core)
    implementation(Deps.Coroutines.android)

    // Hilt
    implementation(Deps.Dagger.hiltAndroid)
    kapt(Deps.Dagger.hiltCompiler)
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

    // Turbine
    testImplementation(TestDeps.Turbine.turbine)
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

private fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
    add("api", dependencyNotation)

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

private fun DependencyHandler.project(
    path: String,
    configuration: String? = null
): ProjectDependency {
    val notation = if (configuration != null) {
        mapOf("path" to path, "configuration" to configuration)
    } else {
        mapOf("path" to path)
    }

    return uncheckedCast(project(notation))
}

@Suppress("unchecked_cast", "nothing_to_inline", "detekt.UnsafeCast")
private inline fun <T> uncheckedCast(obj: Any?): T = obj as T
