package com.dokarun.zigzag.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Text
import com.dokarun.zigzag.ui.theme.ZigzagTheme

@Composable
internal fun Chip(
    modifier: Modifier = Modifier,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    selectedForegroundColor: Color = ZigzagTheme.colors.white,
    selectedBackgroundColor: Color = ZigzagTheme.colors.black500,
    selectedBorderColor: Color = ZigzagTheme.colors.black500,
    unselectedForegroundColor: Color = ZigzagTheme.colors.black400,
    unselectedBackgroundColor: Color = ZigzagTheme.colors.white,
    unselectedBorderColor: Color = ZigzagTheme.colors.black100,
) {
    Surface(
        modifier = modifier,
        color = if (isSelected) selectedBackgroundColor else unselectedBackgroundColor,
        border = BorderStroke(
            width = 1.dp,
            color = if (isSelected) selectedBorderColor else unselectedBorderColor
        ),
        shape = RoundedCornerShape(6.dp),
        onClick = onClick,
        interactionSource = NoRippleInteractionSource()
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
        ) {
            Text(
                label,
                style = ZigzagTheme.typography.labelMedium,
                color = if (isSelected) selectedForegroundColor else unselectedForegroundColor
            )
        }
    }
}

@Preview
@Composable
internal fun ChipPreivew1() {
    Chip(
        label = "스커트",
        isSelected = true,
        onClick = {}
    )
}

@Preview
@Composable
internal fun ChipPreivew2() {
    Chip(
        label = "스커트",
        isSelected = false,
        onClick = {}
    )
}