import com.example.buildsrc.AppImplementation
import com.example.buildsrc.AppLib.COMPOSE
import com.example.buildsrc.androidTestImplementations
import com.example.buildsrc.debugImplementations
import com.example.buildsrc.implementations
import com.example.buildsrc.kapts
import com.example.buildsrc.testImplementations

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.example.nopyjfmyandroidapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.nopyjfmyandroidapp"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementations(AppImplementation.LIBS)
    testImplementations(AppImplementation.UNIT_TEST)
    androidTestImplementations(AppImplementation.INSTRUMENT_TEST)
    debugImplementations(AppImplementation.DEBUG)
    kapts(AppImplementation.KAPT)

    implementation(platform(COMPOSE))
    androidTestImplementation(platform(COMPOSE))

    implementation(project(":core"))
    implementation(project(":model"))
    implementation(project(":feature-nutrients"))
}