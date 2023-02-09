plugins {
    `android-library`
    kotlin("kapt")
}

android {
    namespace = "com.tomkubasik.example.local"
}

dependencies {
    implementation(project(mapOf("path" to ":domain")))
    kapt(AndroidX.room.compiler)
    implementation(AndroidX.room.ktx)
    implementation(AndroidX.room.paging)
    implementation(AndroidX.paging.runtime)
}
