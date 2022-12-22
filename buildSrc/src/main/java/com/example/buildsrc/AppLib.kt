package com.example.buildsrc

object AppLib {
    const val COMPOSE = "androidx.compose:compose-bom:${AppVersion.COMPOSE_VERSION}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${AppVersion.APP_COMPAT_VERSION}"
    const val MATERIAL = "com.google.android.material:material:${AppVersion.MATERIAL_VERSION}"
    const val JUNIT = "junit:junit:${AppVersion.JUNIT_VERSION}"
    const val JUNIT_EXT = "androidx.test.ext:junit:${AppVersion.JUNIT_EXT_VERSION}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${AppVersion.ESPRESSO_VERSION}"
    const val MATERIAL_YOU = "androidx.compose.material3:material3"
    const val COMPOSE_PREVIEW = "androidx.compose.ui:ui-tooling-preview"
    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling"
    const val COMPOSE_UI_TEST = "androidx.compose.ui:ui-test-junit4"
    const val COMPOSE_UI_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest"
    const val COMPOSE_ICON = "androidx.compose.material:material-icons-extended"
    const val COMPOSE_WINDOW_SIZE = "androidx.compose.material3:material3-window-size-class"
    const val COMPOSE_ACTIVITIES =
        "androidx.activity:activity-compose:${AppVersion.COMPOSE_ACTIVITIES_VERSION}"
    const val COMPOSE_VIEWMODEL =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${AppVersion.COMPOSE_VIEWMODEL_VERSION}"
    const val HILT_ANDROID = "com.google.dagger:hilt-android:${AppVersion.HILT_ANDROID_VERSION}"
    const val HILT_ANDROID_COMPILER =
        "com.google.dagger:hilt-android-compiler:${AppVersion.HILT_ANDROID_VERSION}"
}