import com.example.buildsrc.AppLib.COMPOSE
import com.example.buildsrc.debugImplementations
import com.example.buildsrc.implementations
import com.example.buildsrc.kapts
import com.example.buildsrc.testImplementations
import com.example.buildsrc.FeatureImplementation

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.example.feature_nutrients"
    compileSdk = 33

    defaultConfig {
        minSdk = 23
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    implementations(FeatureImplementation.LIBS)
    testImplementations(FeatureImplementation.UNIT_TEST)
    debugImplementations(FeatureImplementation.DEBUG)
    kapts(FeatureImplementation.KAPT)

    implementation(platform(COMPOSE))
    androidTestImplementation(platform(COMPOSE))

    implementation(project(":core"))
    implementation(project(":model"))

    api(project(":service-nutrients"))
}