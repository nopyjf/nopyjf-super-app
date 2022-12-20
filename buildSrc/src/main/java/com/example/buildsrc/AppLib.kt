package com.example.buildsrc

object AppLib {
    const val COMPOSE = "androidx.compose:compose-bom:${AppVersion.COMPOSE_VERSION}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${AppVersion.APP_COMPAT_VERSION}"
    const val MATERIAL = "com.google.android.material:material:${AppVersion.MATERIAL_VERSION}"
    const val JUNIT = "junit:junit:${AppVersion.JUNIT_VERSION}"
    const val JUNIT_EXT = "androidx.test.ext:junit:${AppVersion.JUNIT_EXT_VERSION}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${AppVersion.ESPRESSO_VERSION}"
}