package com.dokarun.zigzag.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.dokarun.zigzag.ui.theme.ZigzagTheme

@Composable
internal fun TextLogo(
    modifier: Modifier = Modifier,
) {
    Text(
        "ZIGZAG",
        style = ZigzagTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Black),
        color = ZigzagTheme.colors.black700,
        modifier = modifier
    )
}