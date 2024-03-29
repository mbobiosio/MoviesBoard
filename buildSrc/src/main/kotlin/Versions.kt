object Versions {
    object Android {
        const val COMPILE_SDK = 32

        object DefaultConfig {
            const val APPLICATION_ID = "com.cerminnovations.moviesboard"
            const val MIN_ANDROID_SDK = 21
            const val TARGET_ANDROID_SDK = 32
            const val VERSION_CODE = 1
            const val VERSION_NAME = "1.0"
            const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
        }

        object BuildTypes {
            const val DEBUG = "debug"
            const val RELEASE = "release"
        }
    }

    object Gradle {
        const val FIREBASE_CRASHLYTICS = "2.4.1"
        const val GRADLE_VERSION = "7.1.1"
        const val KOTLIN = "1.6.21"
        const val MAVEN_PLUGIN = "2.1"
        const val GOOGLE_SERVICES = "4.3.8"
        const val REMAL_PLUGIN = "1.1.5"
    }

    object Kotlin {
        const val JDK = Gradle.KOTLIN
    }

    object Google {
        object Androidx {
            const val APP_COMPAT = "1.2.0"
            const val CONSTRAINT_LAYOUT = "2.0.4"
            const val CORE_KTX = "1.3.2"
            const val CORE_TESTING = "2.1.0"
            const val ESPRESSO = "3.3.0"
            const val JUNIT_EXT = "1.1.2"
            const val LIFECYCLE = "2.2.0"
            const val RECYCLERVIEW = "1.2.0-alpha04"
            const val TEST_RULES = "1.3.0"
            const val TEST_RUNNER = "1.2.0"
            const val ROOM = "2.2.5"
            const val WORK_MANAGER = "2.4.0"
            const val NAV_KTX = "2.3.2"
            const val PAGING = "3.0.0-alpha07"
            const val MULTI_DEX = "2.0.1"
        }

        object Firebase {
            const val ANALYTICS = "18.0.0"
            const val CRASHLYTICS = "17.3.0"
        }

        object Material {
            const val DESIGN = "1.2.0"
        }

        object Test {
            const val TRUTH = "1.1"
        }
    }

    object Square {
        const val OK_HTTP = "4.9.0"
        const val RETROFIT = "2.9.0"
        const val RETROFIT_CONVERTER_MOSHI = "2.9.0"
        const val RETROFIT_ADAPTER = "2.9.0"
        const val MOSHI = "1.11.0"
    }

    object RxJava {
        const val RX_JAVA = "2.1.1"
    }

    object Glide {
        const val GLIDE_LIB = "4.10.0"
    }

    object Coroutines {
        const val CORE = "1.4.2"
        const val ANDROID = "1.4.2"
    }

    object Test {
        const val COROUTINES = "1.4.2"
        const val JUNIT = "4.13.1"
        const val MOCKITO_KOTLIN = "2.2.0"
        const val MOCK = "1.10.2"
    }

    object Detekt {
        const val DETEKT_LIB = "1.14.2"
        const val DETEKT_FORMATTING = "1.12.0"
    }

    object Others {
        const val TIMBER = "4.7.1"
        const val INTUIT = "1.0.6"
        const val LIFECYCLE_CONNECTIVITY = "1.0.1"
        const val LOADING_INDICATOR = "2.1.3"
        const val POWER_SPINNER = "1.1.7"
        const val YOUTUBE_PLAYER = "10.0.5"
        const val LOADING_OVERLAY = "1.0.0"
    }
}
