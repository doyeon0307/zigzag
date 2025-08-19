package com.dokarun.zigzag.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object ZigzagTheme {
    val colors: ZigzagColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: ZigzagTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}