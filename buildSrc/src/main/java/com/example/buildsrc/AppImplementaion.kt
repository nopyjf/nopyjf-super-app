package com.example.buildsrc

object AppImplementaion {

    val APP_LIBS = listOf(
        AppLib.APP_COMPAT,
        AppLib.MATERIAL,
        AppLib.MATERIAL_YOU,
        AppLib.COMPOSE_PREVIEW,
        AppLib.COMPOSE_ICON,
        AppLib.COMPOSE_WINDOW_SIZE,
        AppLib.COMPOSE_ACTIVITIES,
        AppLib.COMPOSE_VIEWMODEL,
        AppLib.HILT_ANDROID,
    )

    val APP_UNIT_TEST_LIBS = listOf(
        AppLib.JUNIT,
    )

    val APP_INSTRUMENT_TEST_LIBS = listOf(
        AppLib.JUNIT_EXT,
        AppLib.ESPRESSO,
        AppLib.COMPOSE_UI_TEST
    )

    val APP_DEBUG_LIBS = listOf(
        AppLib.COMPOSE_UI_TOOLING,
        AppLib.COMPOSE_UI_TEST_MANIFEST,
    )

    val APP_KAPT_LIBS = listOf(
        AppLib.HILT_ANDROID_COMPILER,
    )
}