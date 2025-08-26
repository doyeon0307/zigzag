package com.dokarun.zigzag.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.dokarun.zigzag.ui.component.NoRippleInteractionSource
import com.dokarun.zigzag.ui.theme.ZigzagTheme

@Composable
internal fun QuickMenu(
    modifier: Modifier = Modifier,
    image: String,
    imgSize: Dp = 52.dp,
    label: String,
    onClick: () -> Unit,
) {
    Surface(
        modifier = modifier,
        onClick = onClick,
        color = Color.Transparent,
        interactionSource = NoRippleInteractionSource()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            AsyncImage(
                model = image,
                contentDescription = null,
                modifier = Modifier
                    .size(imgSize)
                    .clip(CircleShape),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
            )
            Text(
                label,
                style = ZigzagTheme.typography.bodySmall,
                color = ZigzagTheme.colors.black700
            )
        }
    }
}

@Preview
@Composable
internal fun QuickMenuPreview() {
    QuickMenu(
        image = "https://unsplash.com/ko/%EC%82%AC%EC%A7%84/%EB%82%AE%EC%97%90-%EC%95%BC%EC%99%B8%EC%97%90-%EC%84%9C-%EC%9E%88%EB%8A%94-%EC%84%A0%EA%B8%80%EB%9D%BC%EC%8A%A4%EB%A5%BC-%EB%82%80-%EC%97%AC%EC%9E%90-BteCp6aq4GI",
        label = "무제한발급"
    ) { }
}
