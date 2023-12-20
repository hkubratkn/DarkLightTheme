package com.example.myapplication.ui.theme

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColorScheme(
    primary = Blue600,
    primaryContainer = Blue800,
    secondary = Orange800,
    secondaryContainer = Orange800
)

private val DarkColorPalette = darkColorScheme(
    primary = Blue200,
    primaryContainer = Blue800,
    secondary = Orange300,
    secondaryContainer = Orange300
)

@Composable
fun ComposeFunctionsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val palette = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = palette.switch(),
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
private fun animateColor(targetValue: Color) =
    animateColorAsState(
        targetValue = targetValue,
        animationSpec = tween(durationMillis = 2000)
    ).value

@Composable
fun ColorScheme.switch() = copy(
    primary = animateColor(primary),
    primaryContainer = animateColor(primaryContainer),
    secondary = animateColor(secondary),
    secondaryContainer = animateColor(secondaryContainer),
    background = animateColor(background),
    surface = animateColor(surface),
    error = animateColor(error),
    onPrimary = animateColor(onPrimary),
    onSecondary = animateColor(onSecondary),
    onBackground = animateColor(onBackground),
    onSurface = animateColor(onSurface),
    onError = animateColor(onError)
)