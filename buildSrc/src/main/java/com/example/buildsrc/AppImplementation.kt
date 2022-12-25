package com.example.buildsrc

interface LibImplementation {
    val LIBS: List<String>
    val UNIT_TEST: List<String>
    val DEBUG: List<String>
    val KAPT: List<String>
    val ANNOTATION: List<String>
}

interface InstrumentImplementation : LibImplementation {
    val INSTRUMENT_TEST: List<String>
}

object CoreImplementation : LibImplementation {
    override val LIBS = listOf(
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

    override val UNIT_TEST = listOf(
        AppLib.JUNIT,
    )

    override val DEBUG = listOf(
        AppLib.COMPOSE_UI_TOOLING,
        AppLib.COMPOSE_UI_TEST_MANIFEST,
    )

    override val KAPT = listOf(
        AppLib.HILT_ANDROID_COMPILER,
        AppLib.ROOM_COMPILER,
    )

    override val ANNOTATION = listOf(
        AppLib.ROOM_COMPILER,
    )
}

object FeatureImplementation : LibImplementation {
    override val LIBS = listOf(
        AppLib.APP_COMPAT,
        AppLib.MATERIAL,
        AppLib.COMPOSE_MATERIAL_YOU,
        AppLib.COMPOSE_PREVIEW,
        AppLib.COMPOSE_ICON,
        AppLib.COMPOSE_WINDOW_SIZE,
        AppLib.COMPOSE_ACTIVITIES,
        AppLib.COMPOSE_VIEWMODEL,
        AppLib.HILT_ANDROID,
    )

    override val UNIT_TEST = listOf(
        AppLib.JUNIT,
    )

    override val DEBUG = listOf(
        AppLib.COMPOSE_UI_TOOLING,
        AppLib.COMPOSE_UI_TEST_MANIFEST,
    )

    override val KAPT = listOf(
        AppLib.HILT_ANDROID_COMPILER,
    )

    override val ANNOTATION = listOf<String>()
}

object ServiceImplementation : LibImplementation {

    override val LIBS = listOf(
        AppLib.HILT_ANDROID,
        AppLib.ROOM,
        AppLib.ROOM_COROUTINE,
    )

    override val UNIT_TEST = listOf(
        AppLib.JUNIT,
    )

    override val DEBUG = listOf(
        AppLib.COMPOSE_UI_TOOLING,
        AppLib.COMPOSE_UI_TEST_MANIFEST,
    )

    override val KAPT = listOf(
        AppLib.HILT_ANDROID_COMPILER,
        AppLib.ROOM_COMPILER,
    )

    override val ANNOTATION = listOf(
        AppLib.ROOM_COMPILER,
    )
}

object AppImplementation : LibImplementation, InstrumentImplementation {

    override val LIBS = listOf(
        AppLib.APP_COMPAT,
        AppLib.MATERIAL,
        AppLib.COMPOSE_MATERIAL_YOU,
        AppLib.COMPOSE_PREVIEW,
        AppLib.COMPOSE_ICON,
        AppLib.COMPOSE_WINDOW_SIZE,
        AppLib.COMPOSE_ACTIVITIES,
        AppLib.COMPOSE_VIEWMODEL,
        AppLib.ROOM,
        AppLib.HILT_ANDROID,
    )

    override val UNIT_TEST = listOf(
        AppLib.JUNIT,
    )

    override val DEBUG = listOf(
        AppLib.COMPOSE_UI_TOOLING,
        AppLib.COMPOSE_UI_TEST_MANIFEST,
    )

    override val KAPT = listOf(
        AppLib.HILT_ANDROID_COMPILER,
        AppLib.ROOM_COMPILER,
    )

    override val ANNOTATION = listOf(
        AppLib.ROOM_COMPILER,
    )

    override val INSTRUMENT_TEST = listOf(
        AppLib.JUNIT_EXT,
        AppLib.ESPRESSO,
        AppLib.COMPOSE_UI_TEST
    )
}

object ModelImplementation : LibImplementation {
    override val LIBS = listOf(
        AppLib.ROOM,
    )

    override val UNIT_TEST = listOf(
        AppLib.JUNIT,
    )

    override val DEBUG = listOf<String>()

    override val KAPT = listOf(
        AppLib.ROOM_COMPILER,
    )

    override val ANNOTATION = listOf(
        AppLib.ROOM_COMPILER,
    )
}