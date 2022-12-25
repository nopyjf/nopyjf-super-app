import com.example.buildsrc.AppLib.COMPOSE
import com.example.buildsrc.annotationProcessors
import com.example.buildsrc.debugImplementations
import com.example.buildsrc.implementations
import com.example.buildsrc.kapts
import com.example.buildsrc.testImplementations
import com.example.buildsrc.CoreImplementation

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.example.core"
    compileSdk = 33

    defaultConfig {
        minSdk = 23
        targetSdk = 33

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
    implementations(CoreImplementation.LIBS)
    testImplementations(CoreImplementation.UNIT_TEST)
    debugImplementations(CoreImplementation.DEBUG)
    kapts(CoreImplementation.KAPT)
    annotationProcessors(CoreImplementation.ANNOTATION)

    implementation(platform(COMPOSE))
    androidTestImplementation(platform(COMPOSE))

    implementation(project(":model"))
}