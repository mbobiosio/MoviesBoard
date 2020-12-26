import org.gradle.api.artifacts.dsl.DependencyHandler
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties


object Dependencies {

    internal const val GRADLE_ANDROID_TOOLS = "com.android.tools.build:gradle:${Versions.Gradle.GRADLE_ANDROID}"
    internal const val GRADLE_FIREBASE_CRASHLYTICS = "com.google.firebase:firebase-crashlytics-gradle:${Versions.Gradle.FIREBASE_CRASHLYTICS}"
    internal const val GRADLE_GOOGLE_SERVICES = "com.google.gms:google-services:${Versions.Gradle.GOOGLE_SERVICES}"
    internal const val GRADLE_KOTLIN_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Gradle.KOTLIN}"
    internal const val GRADLE_KOTLIN_SERIALIZATION = "org.jetbrains.kotlin:kotlin-serialization:${Versions.Gradle.KOTLIN}"
    internal const val GRADLE_MAVEN_PLUGIN = "com.github.dcendents:android-maven-gradle-plugin:${Versions.Gradle.MAVEN_PLUGIN}"
    internal const val GRADLE_REMAL_PLUGIN = "name.remal:gradle-plugins:${Versions.Gradle.REMAL_PLUGIN}"
    internal const val GRADLE_NAVIGATION_PLUGIN = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Google.Androidx.NAV_KTX}"

    internal const val KOTLIN_JDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Kotlin.JDK}"

    internal const val ANDROID_APP_COMPAT = "androidx.appcompat:appcompat:${Versions.Google.Androidx.APP_COMPAT}"
    internal const val ANDROID_CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.Google.Androidx.CONSTRAINT_LAYOUT}"
    internal const val ANDROID_CORE_KTX = "androidx.core:core-ktx:${Versions.Google.Androidx.CORE_KTX}"
    internal const val ANDROID_NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${Versions.Google.Androidx.NAV_KTX}"
    internal const val ANDROID_NAVIGATION_KTX = "androidx.navigation:navigation-ui-ktx:${Versions.Google.Androidx.NAV_KTX}"
    internal const val ANDROID_PAGING = "androidx.paging:paging-runtime-ktx:${Versions.Google.Androidx.PAGING}"

    internal const val ANDROID_LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Google.Androidx.LIFECYCLE}"
    internal const val ANDROID_LIFECYCLE_LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Google.Androidx.LIFECYCLE}"
    internal const val ANDROID_MATERIAL = "com.google.android.material:material:${Versions.Google.Material.DESIGN}"
    internal const val ANDROID_RECYCLERVIEW = "androidx.recyclerview:recyclerview:${Versions.Google.Androidx.RECYCLERVIEW}"

    //Coroutines
    internal const val KOTLIN_COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Coroutines.CORE}"
    internal const val KOTLIN_COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Coroutines.ANDROID}"

    internal const val ANDROID_CORE_TESTING = "androidx.arch.core:core-testing:${Versions.Google.Androidx.CORE_TESTING}"
    internal const val ANDROID_JUNIT_EXT = "androidx.test.ext:junit:${Versions.Google.Androidx.JUNIT_EXT}"
    internal const val ANDROID_ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.Google.Androidx.ESPRESSO}"
    internal const val ANDROID_TEST_RULES = "androidx.test:rules:${Versions.Google.Androidx.TEST_RULES}"
    internal const val ANDROID_TEST_RUNNER = "androidx.test:runner:${Versions.Google.Androidx.TEST_RUNNER}"

    internal const val ANDROID_ROOM_COMPILER = "androidx.room:room-compiler:${Versions.Google.Androidx.ROOM}"
    internal const val ANDROID_ROOM_KTX = "androidx.room:room-ktx:${Versions.Google.Androidx.ROOM}"
    internal const val ANDROID_ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.Google.Androidx.ROOM}"
    internal const val ANDROID_WORK_MANAGER = "androidx.work:work-runtime-ktx:${Versions.Google.Androidx.WORK_MANAGER}"

    internal const val ANDROID_TEST_TRUTH = "com.google.truth:truth:${Versions.Google.Test.TRUTH}"

    //Firebase
    internal const val FIREBASE_ANALYTICS = "com.google.firebase:firebase-analytics-ktx:${Versions.Google.Firebase.ANALYTICS}"
    internal const val FIREBASE_CRASHLYTICS = "com.google.firebase:firebase-crashlytics:${Versions.Google.Firebase.CRASHLYTICS}"

    //SQUARE
    internal const val SQUARE_OK_HTTP = "com.squareup.okhttp3:okhttp:${Versions.Square.OK_HTTP}"
    internal const val SQUARE_OK_HTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.Square.OK_HTTP}"
    internal const val SQUARE_RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.Square.RETROFIT}"
    internal const val SQUARE_MOSHI = "com.squareup.moshi:moshi-kotlin:${Versions.Square.MOSHI}"
    internal const val SQUARE_CONVERTER_MOSHI = "com.squareup.retrofit2:converter-moshi:${Versions.Square.RETROFIT_CONVERTER_MOSHI}"
    //internal const val SQUARE_RETROFIT_ADAPTER = "com.squareup.retrofit2:adapter-rxjava2:${Versions.Square.RETROFIT_ADAPTER}"

    //RXJAVA
    internal const val RX_JAVA = "io.reactivex.rxjava2:rxandroid:${Versions.RxJava.RX_JAVA}"

    //DETEKT
    const val DETEKT = Versions.Detekt.DETEKT
    const val DETEKT_PLUGIN = "io.gitlab.arturbosch.detekt"
    internal const val DETEKT_FORMATTING = "io.gitlab.arturbosch.detekt:detekt-formatting:${Versions.Detekt.DETEKT_FORMATTING}"

    // Timber - Logging Library
    internal const val TIMBER = "com.jakewharton.timber:timber:${Versions.Others.TIMBER}"

    //Intuit
    internal const val INTUIT_SDP = "com.intuit.sdp:sdp-android:${Versions.Others.INTUIT}"
    internal const val INTUIT_SSP = "com.intuit.ssp:ssp-android:${Versions.Others.INTUIT}"

    //Lifecycle Connectivity
    internal const val LIFECYCLE_CONNECTIVITY = "com.github.mbobiosio:lifecycleconnectivity:${Versions.Others.LIFECYCLE_CONNECTIVITY}"

    //Loading Indicator
    internal const val LOADING_LIBRARY = "com.wang.avi:library:${Versions.Others.LOADING_INDICATOR}"

    //Glide
    internal const val GLIDE = "com.github.bumptech.glide:glide:${Versions.Glide.GLIDE}"
    internal const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Versions.Glide.GLIDE}"
    internal const val GLIDE_SVG = "com.github.qoqa:glide-svg:${Versions.Glide.GLIDE_SVG}"


}

fun DependencyHandler.gradle() {
    classpath(Dependencies.GRADLE_ANDROID_TOOLS)
    classpath(Dependencies.GRADLE_FIREBASE_CRASHLYTICS)
    classpath(Dependencies.GRADLE_GOOGLE_SERVICES)
    classpath(Dependencies.GRADLE_KOTLIN_PLUGIN)
    classpath(Dependencies.GRADLE_KOTLIN_SERIALIZATION)
    classpath(Dependencies.GRADLE_MAVEN_PLUGIN)
    classpath(Dependencies.GRADLE_REMAL_PLUGIN)
    classpath(Dependencies.GRADLE_NAVIGATION_PLUGIN)
}

fun DependencyHandler.kotlin() {
    implementation(Dependencies.KOTLIN_JDK)
}

fun DependencyHandler.google() {
    implementation(Dependencies.ANDROID_APP_COMPAT)
    implementation(Dependencies.ANDROID_CONSTRAINT_LAYOUT)
    implementation(Dependencies.ANDROID_CORE_KTX)
    implementation(Dependencies.ANDROID_LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.ANDROID_LIFECYCLE_LIVEDATA_KTX)
    implementation(Dependencies.ANDROID_MATERIAL)
    implementation(Dependencies.ANDROID_RECYCLERVIEW)
    implementation(Dependencies.ANDROID_NAVIGATION_FRAGMENT_KTX)
    implementation(Dependencies.ANDROID_NAVIGATION_KTX)
    implementation(Dependencies.ANDROID_PAGING)

    //kapt(Dependencies.ANDROID_ROOM_COMPILER)
}

fun DependencyHandler.coroutines() {
    implementation(Dependencies.KOTLIN_COROUTINES_CORE)
    implementation(Dependencies.KOTLIN_COROUTINES_ANDROID)
}

fun DependencyHandler.firebase() {
    implementation(Dependencies.FIREBASE_ANALYTICS)
    implementation(Dependencies.FIREBASE_CRASHLYTICS)
}

fun DependencyHandler.rxjava() {
    implementation(Dependencies.RX_JAVA)
}

fun DependencyHandler.square() {
    implementation(Dependencies.SQUARE_OK_HTTP)
    implementation(Dependencies.SQUARE_OK_HTTP_LOGGING_INTERCEPTOR)
    implementation(Dependencies.SQUARE_RETROFIT)
    implementation(Dependencies.SQUARE_CONVERTER_MOSHI)
    //implementation(Dependencies.SQUARE_RETROFIT_ADAPTER)
    implementation(Dependencies.SQUARE_MOSHI)
}

fun DependencyHandler.test() {
    androidTestImplementation(Dependencies.ANDROID_CORE_TESTING)
    androidTestImplementation(Dependencies.ANDROID_JUNIT_EXT)
    androidTestImplementation(Dependencies.ANDROID_ESPRESSO_CORE)
    androidTestImplementation(Dependencies.ANDROID_TEST_RULES)
    androidTestImplementation(Dependencies.ANDROID_TEST_RUNNER)
    androidTestImplementation(Dependencies.ANDROID_TEST_TRUTH)

    testImplementation(Dependencies.ANDROID_CORE_TESTING)
    testImplementation(Dependencies.ANDROID_TEST_TRUTH)
}

fun DependencyHandler.glide() {
    implementation(Dependencies.GLIDE)
    implementation(Dependencies.GLIDE_SVG)
    kapt(Dependencies.GLIDE_COMPILER)
}

fun DependencyHandler.detektFormatting() {
    add("detektPlugins", Dependencies.DETEKT_FORMATTING)
}

fun DependencyHandler.others() {
    implementation(Dependencies.TIMBER)
    implementation(Dependencies.INTUIT_SDP)
    implementation(Dependencies.INTUIT_SSP)
    implementation(Dependencies.LIFECYCLE_CONNECTIVITY)
    implementation(Dependencies.LOADING_LIBRARY)
}

private fun DependencyHandler.classpath(depName: String) {
    add("classpath", depName)
}

private fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}

private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

private fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}

private fun DependencyHandler.api(depName: String) {
    add("api", depName)
}

private fun DependencyHandler.id(depName: String) {
    add("id", depName)
}

private fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation", depName)
}

private fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation", depName)
}