package com.dokarun.zigzag.ui.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import com.dokarun.zigzag.ui.component.NoRippleInteractionSource
import com.dokarun.zigzag.ui.theme.ZigzagTheme

@Composable
internal fun TabItem(
    modifier: Modifier = Modifier,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    selectedColor: Color? = null,
    unselectedColor: Color? = null,
) {
    Surface(
        modifier = modifier,
        color = Color.Transparent,
        onClick = onClick,
        interactionSource = NoRippleInteractionSource()
    ) {
        val selectedColor = selectedColor ?: ZigzagTheme.colors.black700
        val unselectedColor = unselectedColor ?: ZigzagTheme.colors.black300
        Box(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    modifier = Modifier.size(4.dp),
                    shape = CircleShape,
                    color = selectedColor.copy(alpha = if (isSelected) 1.0f else 0.0f)
                ) { }
                Text(
                    label,
                    style = ZigzagTheme.typography.titleMedium,
                    color = if (isSelected) selectedColor else unselectedColor
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun TabItemPreview1() {
    TabItem(
        label = "트렌드",
        isSelected = true,
        onClick = {},
    )
}

@Preview(showBackground = true)
@Composable
internal fun TabItemPreview2() {
    TabItem(
        label = "트렌드",
        isSelected = false,
        onClick = {},
    )
}

@Preview(showBackground = true)
@Composable
internal fun TabItemPreview3() {
    TabItem(
        label = "트렌드",
        isSelected = true,
        onClick = {},
        selectedColor = ZigzagTheme.colors.navy500,
        unselectedColor = ZigzagTheme.colors.white
    )
}

@Preview(showBackground = true)
@Composable
internal fun TabItemPreview4() {
    TabItem(
        label = "트렌드",
        isSelected = false,
        onClick = {},
        selectedColor = ZigzagTheme.colors.navy500,
        unselectedColor = ZigzagTheme.colors.white
    )
}