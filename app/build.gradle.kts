import com.example.buildsrc.AppImplementaion.APP_LIBS
import com.example.buildsrc.AppImplementaion.INSTRUMENT_TEST_LIBS
import com.example.buildsrc.AppImplementaion.UNIT_TEST_LIBS
import com.example.buildsrc.androidTestImplementations
import com.example.buildsrc.implementations
import com.example.buildsrc.testImplementations

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
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

dependencies {
    implementations(APP_LIBS)
    testImplementations(UNIT_TEST_LIBS)
    androidTestImplementations(INSTRUMENT_TEST_LIBS)
}