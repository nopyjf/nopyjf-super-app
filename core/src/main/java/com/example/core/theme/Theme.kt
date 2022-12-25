package com.example.core.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView

val LightTheme = lightColorScheme(
    primary = Red40,
    secondary = RedGrey40,
    tertiary = Yellow40,
)

val DarkTheme = darkColorScheme(
    primary = Red80,
    secondary = RedGrey80,
    tertiary = Yellow80,
)

@Composable
fun AppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    isDynamicColor: Boolean = true,    // we can use dynamic color theme on API level 12+
    content: @Composable () -> Unit,
) {
    val colorScheme = getColorScheme(isDarkTheme, isDynamicColor)
    setStatusBar(colorScheme)

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
private fun getDynamicColorScheme(isDarkTheme: Boolean): ColorScheme {

    val context = LocalContext.current

    return when (isDarkTheme) {
        true -> dynamicDarkColorScheme(context)
        false -> dynamicLightColorScheme(context)
    }
}

@Composable
private fun getColorScheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    isDynamicColor: Boolean = true,
): ColorScheme {
    return when {
        canUseDynamicColor(isDynamicColor) -> getDynamicColorScheme(isDarkTheme)
        isDarkTheme -> DarkTheme
        else -> LightTheme
    }
}

@Composable
private fun setStatusBar(colorScheme: ColorScheme) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
        }
    }
}

private fun canUseDynamicColor(isDynamicColor: Boolean): Boolean {
    return isDynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
}