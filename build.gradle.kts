// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:_")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:_")
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt")
}
apply("pr-code-analysis-project.gradle")
tasks.withType<io.gitlab.arturbosch.detekt.Detekt> {
    exclude("**/build/**")
}

apply("detekt-root.gradle.kts")