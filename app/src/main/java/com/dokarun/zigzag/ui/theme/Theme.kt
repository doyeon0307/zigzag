package com.dokarun.zigzag.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

fun zigzagColors() = ZigzagColors()
fun zigzagFonts() = ZigzagTypography()

@Composable
fun ZIGZAGTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: ZigzagColors = zigzagColors(),
    darkColors: ZigzagColors = zigzagColors(),
    typography: ZigzagTypography = zigzagFonts(),
    content: @Composable () -> Unit,
) {
    val currentColor = remember { if (darkTheme) darkColors else colors }
    val rememberedColors = remember { currentColor.copy() }.apply { updateColorFrom(currentColor) }
    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalTypography provides typography
    ) {
        ProvideTextStyle(typography.bodyLarge, content = content)
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.setDecorFitsSystemWindows(window, false)
        }
    }
}