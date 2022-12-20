package com.example.buildsrc

object AppImplementaion {
    val APP_LIBS = listOf(
        AppLib.APP_COMPAT,
        AppLib.MATERIAL,
    )

    val UNIT_TEST_LIBS = listOf(
        AppLib.JUNIT,
    )

    val INSTRUMENT_TEST_LIBS = listOf(
        AppLib.JUNIT_EXT,
        AppLib.ESPRESSO,
    )
}