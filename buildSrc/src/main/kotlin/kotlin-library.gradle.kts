plugins {
    id("java-library")
    id("kotlin")
    kotlin("kapt")
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation("com.google.dagger:hilt-core:_")
    kapt(Google.dagger.hilt.compiler)
    testImplementation(Testing.junit.jupiter)
    testImplementation(Kotlin.test)
}