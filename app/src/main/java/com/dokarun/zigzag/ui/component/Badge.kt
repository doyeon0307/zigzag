package com.dokarun.zigzag.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dokarun.zigzag.ui.theme.ZigzagTheme

@Composable
internal fun BaseBadge(
    modifier: Modifier = Modifier,
    label: String,
    foregroundColor: Color = ZigzagTheme.colors.white,
    backgroundColor: Color = ZigzagTheme.colors.black500,
) {
    Surface(
        modifier = modifier,
        color = backgroundColor.copy(alpha = 0.4f),
        shape = RoundedCornerShape(2.dp)
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
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
internal fun Badge(
    modifier: Modifier = Modifier,
    label: String,
    badgeStyle: BadgeStyle,
) {
    BaseBadge(
        modifier = modifier,
        label = label,
        foregroundColor = badgeStyle.colors().foreground,
        backgroundColor = badgeStyle.colors().background
    )
}

data class BadgeColors(
    val foreground: Color,
    val background: Color,
)

enum class BadgeStyle {
    GRAY,
    PINK;

    @Composable
    fun colors(): BadgeColors = when (this) {
        GRAY -> BadgeColors(
            foreground = ZigzagTheme.colors.black300,
            background = ZigzagTheme.colors.black100
        )
        PINK -> BadgeColors(
            foreground = ZigzagTheme.colors.pink800,
            background = ZigzagTheme.colors.pink100
        )
    }
}

@Preview
@Composable
internal fun GrayBadgePreview() {
    Badge(
        label = "무료배송",
        badgeStyle = BadgeStyle.GRAY
    )
}

@Preview
@Composable
internal fun PinkBadgePreview() {
    Badge(
        label = "무료배송",
        badgeStyle = BadgeStyle.PINK
    )
}