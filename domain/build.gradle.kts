plugins {
    `kotlin-library`
}

description = "Business layer"

dependencies {
    implementation(KotlinX.coroutines.core)
    implementation(AndroidX.paging.commonKtx)
}
