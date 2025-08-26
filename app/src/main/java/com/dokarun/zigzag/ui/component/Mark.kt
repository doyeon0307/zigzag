package com.dokarun.zigzag.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dokarun.zigzag.ui.theme.ZigzagTheme

@Composable
internal fun Mark(
    modifier: Modifier = Modifier,
    label: String = "M",
    backgroundColor: Color = ZigzagTheme.colors.orange100,
    foregroundColor: Color = ZigzagTheme.colors.orange500,
) {
    Surface(
        modifier = modifier.size(12.dp),
        shape = CircleShape,
        color = backgroundColor
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                label,
                style = ZigzagTheme.typography.labelTiny,
                color = foregroundColor
            )
        }
    }
}

@Preview
@Composable
internal fun MarkPreveiw() {
    Mark()
}