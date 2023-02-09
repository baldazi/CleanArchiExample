// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Android.tools.build.gradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:_")
        classpath(Google.dagger.hilt.android.gradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt")
}

apply("pr-code-analysis-project.gradle")
tasks.withType<io.gitlab.arturbosch.detekt.Detekt> {
    exclude("**/build/**")
}

detekt {
    config = files("$projectDir/detekt-config.yml")
}