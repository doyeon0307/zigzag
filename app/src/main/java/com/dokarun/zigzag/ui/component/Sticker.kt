package com.dokarun.zigzag.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dokarun.zigzag.ui.theme.ZigzagTheme

@Composable
internal fun BaseSticker(
    modifier: Modifier = Modifier,
    label: String,
    foregroundColor: Color,
    backgroundColor: Color,
) {
    Surface(
        modifier = modifier,
        color = backgroundColor,
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                label,
                style = ZigzagTheme.typography.labelSmall,
                color = foregroundColor
            )
        }
    }
}

@Composable
internal fun Sticker(
    modifier: Modifier = Modifier,
    label: String,
    stickerStyle: StickerStyle,
) {
    BaseSticker(
        modifier = modifier,
        label = label,
        foregroundColor = stickerStyle.colors().foreground,
        backgroundColor = stickerStyle.colors().background
    )
}

data class StickerColors(
    val foreground: Color,
    val background: Color,
)

enum class StickerStyle {
    Purple;

    @Composable
    fun colors(): StickerColors = when (this) {
        Purple -> StickerColors(
            foreground = ZigzagTheme.colors.white,
            background = ZigzagTheme.colors.purple500
        )
    }
}

@Preview
@Composable
internal fun PurpleStickerPreveiw() {
    Sticker(
        label = "직진배송",
        stickerStyle = StickerStyle.Purple
    )
}