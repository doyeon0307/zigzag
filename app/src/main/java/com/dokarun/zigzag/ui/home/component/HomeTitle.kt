package com.dokarun.zigzag.ui.home.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dokarun.zigzag.ui.theme.ZigzagTheme

@Composable
internal fun HomeTitle (
    modifier: Modifier = Modifier,
    title: String,
) {
    Text(
        title,
        style = ZigzagTheme.typography.titleMedium,
        color = ZigzagTheme.colors.black700
    )
}