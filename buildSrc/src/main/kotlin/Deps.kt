/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
object Deps {

    object Coroutines {
        private const val version = "1.6.1"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object Google {
        const val material = "com.google.android.material:material:1.8.0-alpha02"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.5.1"
        const val coreKtx = "androidx.core:core-ktx:1.9.0"
        const val pagingRuntime = "androidx.paging:paging-runtime-ktx:3.1.1"
        const val activityKtx = "androidx.activity:activity-ktx:1.4.0"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.4.1"
        const val multiDex = "androidx.multidex:multidex:2.0.1"
        const val viewPager2 = "androidx.viewpager2:viewpager2:1.1.0-alpha01"

        object Constraint {
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        }

        object Lifecycle {
            private const val version = "2.4.1"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
        }

        object Navigation {
            private const val version = "2.5.3"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
        }

        object Room {
            private const val version = "2.4.2"
            const val runtime = "androidx.room:room-runtime:$version"
            const val ktx = "androidx.room:room-ktx:$version"
            const val compiler = "androidx.room:room-compiler:$version"
            const val room_paging = "androidx.room:room-paging:$version"
        }

        object Splash {
            const val splashScreen = "androidx.core:core-splashscreen:1.0.0-rc01"
        }
    }

    object Intuit {
        private const val version = "1.0.6"
        const val sdp = "com.intuit.sdp:sdp-android:$version"
        const val ssp = "com.intuit.ssp:ssp-android:$version"
    }

    object Dagger {
        private const val version = PluginVersion.HILT
        const val hiltAndroid = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:$version"
    }

    object OkHttp {
        private const val version = "4.9.1"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val logging = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val retrofitConverter = "com.squareup.retrofit2:converter-moshi:$version"
    }

    object Moshi {
        private const val version = "1.13.0"
        const val moshi = "com.squareup.moshi:moshi-kotlin:$version"
        const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
    }

    object Glide {
        private const val version = "4.10.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val glideCompiler = "com.github.bumptech.glide:compiler:$version"
    }

    object Coil {
        private const val version = "2.1.0"
        const val coil = "io.coil-kt:coil:$version"
    }

    object Timber {
        const val timber = "com.jakewharton.timber:timber:5.0.1"
    }

    const val youtubePlayer = "com.pierfrancescosoffritti.androidyoutubeplayer:core:11.0.1"
    const val powerSpinner = "com.github.skydoves:powerspinner:1.2.1"
    const val materialRatingBar = "me.zhanghai.android.materialratingbar:library:1.4.0"
    const val skeletonLayout = "com.faltenreich:skeletonlayout:4.0.0"
    const val androidVeil = "com.github.skydoves:androidveil:1.1.2"
}

object TestDeps {
    object AndroidX {
        private const val version = "1.4.0"

        // AndroidX Test - JVM Testing
        const val coreKtx = "androidx.test:core-ktx:$version"
        const val rules = "androidx.test:rules:$version"
        const val coreTesting = "androidx.arch.core:core-testing:2.1.0"
        const val androidX_jUnit = "androidx.test.ext:junit-ktx:1.1.3"
        const val navigationTest = "androidx.navigation:navigation-testing:2.4.2"
        const val room = "androidx.room:room-testing:2.4.2"
    }

    object Coroutines {
        private const val version = "1.6.1"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object JUnit {
        private const val version = "4.13.2"
        const val junit = "junit:junit:$version"
    }

    object MockWebServer {
        private const val version = "4.9.3"
        const val mockwebserver = "com.squareup.okhttp3:mockwebserver:$version"
        const val okhttpIdlingResource = "com.jakewharton.espresso:okhttp3-idling-resource:1.0.0"
    }

    object MockK {
        const val mockK = "io.mockk:mockk:1.10.0"
    }

    object Mockito {
        private const val mockitoVersion = "4.3.0"
        const val core = "org.mockito.kotlin:mockito-kotlin:4.0.0"
        const val android = "org.mockito:mockito-android:$mockitoVersion"
    }

    object Turbine {
        private const val version = "0.8.0"
        const val turbine = "app.cash.turbine:turbine:$version"
    }

    const val truth = "com.google.truth:truth:1.1.2"
    const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
}
