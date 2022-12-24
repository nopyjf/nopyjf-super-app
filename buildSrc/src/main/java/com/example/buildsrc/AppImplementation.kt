package com.example.buildsrc

object AppImplementation {

    val APP_LIBS = listOf(
        AppLib.APP_COMPAT,
        AppLib.MATERIAL,
        AppLib.COMPOSE_MATERIAL_YOU,
        AppLib.COMPOSE_PREVIEW,
        AppLib.COMPOSE_ICON,
        AppLib.COMPOSE_WINDOW_SIZE,
        AppLib.COMPOSE_ACTIVITIES,
        AppLib.COMPOSE_VIEWMODEL,
        AppLib.HILT_ANDROID,
        AppLib.ROOM,
        AppLib.ROOM_COROUTINE,
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
        AppLib.ROOM_COMPILER,
    )

    val APP_ANNOTATION_LIBS = listOf(
        AppLib.ROOM_COMPILER,
    )
}