// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
    }
    dependencies {
        val navVersion = "2.5.3"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
    }
}
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.0" apply false
    id("com.android.library") version "8.1.1" apply false
    id ("com.google.dagger.hilt.android") version "2.44" apply false
}
