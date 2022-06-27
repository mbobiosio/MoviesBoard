plugins {
    id(Plugins.ANDROID_APPLICATION) version (PluginVersion.AGP) apply false
    id(Plugins.ANDROID_LIBRARY) version (PluginVersion.AGP) apply false
    kotlin(Plugins.ANDROID) version (PluginVersion.KOTLIN) apply false
    id(Plugins.ANDROIDX_NAVIGATION) version (PluginVersion.NAVIGATION) apply false
    // id(Plugins.GOOGLE_DAGGER_HILT) version (PluginVersion.HILT) apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
