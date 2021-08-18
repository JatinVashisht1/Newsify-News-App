package com.example.newsify.ui.theme
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode.Companion.Color

private val DarkColorPalette = darkColors(
    primary = ColorPrimaryDark,
    primaryVariant = ColorPrimaryVariantDark,
    secondary = ColorSecondaryDark,

    background = ColorPrimaryDark,
    surface = ColorPrimaryVariantDark,
    onPrimary = ColorOnPrimaryDark,
    onSecondary = ColorOnSecondaryDark,
    onBackground = ColorOnPrimaryDark,
    onSurface = ColorOnPrimaryDark,
    secondaryVariant = Color200
)

private val LightColorPalette = lightColors(
    primary = ColorPrimaryLight,
    primaryVariant = ColorPrimaryVariantLight,
    secondary = ColorSecondaryLight,

    //Other default colors to override
    background = ColorPrimaryLight,
    surface = ColorSurfaceLight,
    onPrimary = ColorOnPrimaryLight,
    onSecondary = ColorOnSecondaryLight,
    onBackground = ColorOnPrimaryLight,
    onSurface = ColorOnSurfaceLight,
    secondaryVariant = Teal200

)

@Composable
fun NewsifyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}