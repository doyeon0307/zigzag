package com.dokarun.zigzag.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.dokarun.zigzag.R
import com.dokarun.zigzag.ui.theme.ZigzagTheme

@Composable
internal fun VoteCard(
    modifier: Modifier = Modifier,
    image: String?,
    imgSize: Dp = 48.dp,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = if (isSelected) ZigzagTheme.colors.pink100.copy(alpha = 0.4f) else ZigzagTheme.colors.white,
        border = BorderStroke(
            width = 1.dp,
            color = if (isSelected) ZigzagTheme.colors.pink500 else ZigzagTheme.colors.black100
        )
    ) {
        Row {
            if (image != null) {
                AsyncImage(
                    model = image,
                    contentDescription = null,
                    modifier = Modifier.size(imgSize),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop,
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    label,
                    style = ZigzagTheme.typography.bodyMedium,
                    color = ZigzagTheme.colors.black700
                )
                IconButton(
                    onClick = onClick,
                ) {
                    Icon(
                        painter = painterResource(if (isSelected) R.drawable.ic_radio_checked else R.drawable.ic_radio_unchecked),
                        contentDescription = "Radio Button",
                        tint = if (isSelected) ZigzagTheme.colors.pink500 else ZigzagTheme.colors.black200
                    )
                }
            }
        }
    }
}

@Preview
@Composable
internal fun VoteCardPreview() {
    VoteCard(
        image = "hakfalskf",
        label = "몬테 밴딩 블라우스",
        isSelected = true,
        onClick = {}
    )
}

@Preview
@Composable
internal fun VoteCardPreview2() {
    VoteCard(
        image = "hakfalskf",
        label = "몬테 밴딩 블라우스",
        isSelected = false,
        onClick = {}
    )
}

@Preview
@Composable
internal fun VoteCardPrevi3ew() {
    VoteCard(
        image = null,
        label = "몬테 밴딩 블라우스",
        isSelected = true,
        onClick = {}
    )
}