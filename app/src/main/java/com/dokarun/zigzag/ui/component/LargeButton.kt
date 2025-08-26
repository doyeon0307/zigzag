package com.dokarun.zigzag.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dokarun.zigzag.ui.theme.ZigzagTheme

@Composable
internal fun LargeButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    isEnabled: Boolean,
    onDisabledClick: (() -> Unit)? = null,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = if (isEnabled) ZigzagTheme.colors.black700 else ZigzagTheme.colors.black100.copy(
            alpha = 0.6f
        ),
        shape = RoundedCornerShape(20.dp),
        onClick = if (isEnabled) onClick else onDisabledClick ?: {}
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                label,
                style = ZigzagTheme.typography.labelLarge,
                color = if (isEnabled) ZigzagTheme.colors.white else ZigzagTheme.colors.black300
            )
        }
    }
}

@Preview
@Composable
internal fun LargeButtonPreview() {
    LargeButton(
        label = "상품 선택하고 5 포인트 받기",
        onClick = {},
        isEnabled = true,
    )
}

@Preview
@Composable
internal fun LargeButtonPreview2() {
    LargeButton(
        label = "상품 선택하고 5 포인트 받기",
        onClick = {},
        isEnabled = false,
    )
}