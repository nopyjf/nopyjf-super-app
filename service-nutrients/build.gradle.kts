import com.example.buildsrc.ServiceImplementation
import com.example.buildsrc.annotationProcessors
import com.example.buildsrc.implementations
import com.example.buildsrc.kapts
import com.example.buildsrc.testImplementations

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "com.example.service_nutrients"
    compileSdk = 33

    defaultConfig {
        minSdk = 23
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementations(ServiceImplementation.LIBS)
    testImplementations(ServiceImplementation.UNIT_TEST)
    kapts(ServiceImplementation.KAPT)
    annotationProcessors(ServiceImplementation.ANNOTATION)

    implementation(project(":core"))
    implementation(project(":model"))
}