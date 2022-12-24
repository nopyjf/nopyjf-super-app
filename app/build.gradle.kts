import com.example.buildsrc.AppImplementation.APP_ANNOTATION_LIBS
import com.example.buildsrc.AppImplementation.APP_LIBS
import com.example.buildsrc.AppImplementation.APP_DEBUG_LIBS
import com.example.buildsrc.AppImplementation.APP_INSTRUMENT_TEST_LIBS
import com.example.buildsrc.AppImplementation.APP_KAPT_LIBS
import com.example.buildsrc.AppImplementation.APP_UNIT_TEST_LIBS
import com.example.buildsrc.AppLib.COMPOSE
import com.example.buildsrc.androidTestImplementations
import com.example.buildsrc.annotationProcessors
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
            isMinifyEnabled = false
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
    implementations(APP_LIBS)
    testImplementations(APP_UNIT_TEST_LIBS)
    androidTestImplementations(APP_INSTRUMENT_TEST_LIBS)
    debugImplementations(APP_DEBUG_LIBS)
    kapts(APP_KAPT_LIBS)
    annotationProcessors(APP_ANNOTATION_LIBS)

    implementation(platform(COMPOSE))
    androidTestImplementation(platform(COMPOSE))
}