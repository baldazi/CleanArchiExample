plugins {
    `application-flavors`
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
    id("kotlin-android")
}

android {

    compileSdk = AndroidConfig.COMPILE_SDK
    buildToolsVersion = AndroidConfig.BUILD_TOOLS_VERSION

    defaultConfig {
        minSdk = AndroidConfig.MIN_SDK
        targetSdk = AndroidConfig.TARGET_SDK

        versionCode = System.getenv(EnvConfig.ENV_VERSION_CODE)?.toInt() ?: AndroidConfig.VERSION_CODE
        versionName = System.getenv(EnvConfig.ENV_VERSION_NAME) ?: AndroidConfig.VERSION_NAME
    }

    signingConfigs {
        maybeCreate("dev").apply {
        }
        maybeCreate("releaseProd").apply {
        }
    }

    buildTypes {
        debug {
            // Uncomment the following line to use the flavor signing
            // signingConfig = null
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles += getDefaultProguardFile("proguard-android-optimize.txt")
            proguardFiles += File("proguard-rules.pro")
        }
    }

    kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "_"
    }
}

hilt {
    enableAggregatingTask = true
}

dependencies {
    implementation(Google.dagger.hilt.android)
    implementation(AndroidX.security.crypto)
    implementation(Kotlin.stdlib.jdk8)

    kapt(Google.dagger.hilt.compiler)

    implementation(KotlinX.coroutines.android)

    implementation(AndroidX.appCompat)
    implementation(AndroidX.core.ktx)
    implementation(AndroidX.lifecycle.runtime.ktx)
    implementation(AndroidX.lifecycle.runtime.compose)

    implementation(Google.android.material)

    implementation(AndroidX.paging.runtime)

    // Compose
    implementation(platform(AndroidX.compose.bom))
    implementation(AndroidX.compose.ui)
    implementation(AndroidX.paging.compose)
    debugImplementation(AndroidX.compose.ui.tooling)
    implementation(AndroidX.compose.ui.toolingPreview)
    implementation(AndroidX.compose.material3)
    implementation(AndroidX.compose.material)
    implementation(AndroidX.Activity.compose)
    implementation(AndroidX.hilt.navigationCompose)
    implementation(AndroidX.navigation.compose)
    implementation(AndroidX.compose.material.icons.extended)
    implementation(AndroidX.compose.foundation)
    implementation(Google.accompanist.navigationAnimation)
    implementation(Google.accompanist.systemUiController)
    implementation(KotlinX.collections.immutable)
    implementation(Google.accompanist.pager.indicators)
    implementation(Google.accompanist.pager)

    runtimeOnly(project(":local-android"))

    implementation(project(":domain"))
}

