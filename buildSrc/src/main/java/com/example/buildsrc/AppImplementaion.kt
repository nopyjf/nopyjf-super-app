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
    )

    val UNIT_TEST_LIBS = listOf(
        AppLib.JUNIT,
    )

    val INSTRUMENT_TEST_LIBS = listOf(
        AppLib.JUNIT_EXT,
        AppLib.ESPRESSO,
        AppLib.COMPOSE_UI_TEST
    )

    val DEBUG_LIBS = listOf(
        AppLib.COMPOSE_UI_TOOLING,
        AppLib.COMPOSE_UI_TEST_MANIFEST,
    )
}