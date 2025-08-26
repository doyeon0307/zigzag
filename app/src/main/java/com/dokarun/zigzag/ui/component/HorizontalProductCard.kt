package com.dokarun.zigzag.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.dokarun.zigzag.R
import com.dokarun.zigzag.ui.theme.ZigzagTheme
import com.dokarun.zigzag.util.addComma

@Composable
internal fun HorizontalProductCard(
    modifier: Modifier = Modifier,
    image: String,
    productName: String,
    storeName: String,
    discountRate: Int? = null,
    price: Int,
    badgeLabels: List<String>? = null,
    badgeStyls: List<BadgeStyle>? = null,
    isFavorited: Boolean,
    onFavoriteClick: () -> Unit,
    showMark: Boolean,
) {
    Surface(
        modifier = modifier,
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp, bottom = 12.dp, end = 8.dp)
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(5f / 6f)
                ) {
                    AsyncImage(
                        model = image,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        Text(
                            storeName,
                            style = ZigzagTheme.typography.titleSmall,
                            color = ZigzagTheme.colors.black700
                        )
                        if (showMark) {
                            Mark()
                        }
                    }
                    Text(
                        productName,
                        style = ZigzagTheme.typography.bodyMedium,
                        color = ZigzagTheme.colors.black700,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        if (discountRate != null) {
                            Text(
                                "$discountRate%",
                                style = ZigzagTheme.typography.titleMedium,
                                color = ZigzagTheme.colors.pink500,
                            )
                        }
                        Text(
                            price.addComma(),
                            style = ZigzagTheme.typography.titleMedium,
                            color = ZigzagTheme.colors.black700,
                        )
                    }
                    if (badgeLabels != null && badgeStyls != null) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            badgeLabels.forEachIndexed { index, label ->
                                Badge(
                                    label = label,
                                    badgeStyle = badgeStyls[index]
                                )
                            }
                        }
                    }
                }
                Surface(
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.CenterVertically),
                    color = Color.Transparent,
                    onClick = onFavoriteClick,
                    interactionSource = NoRippleInteractionSource(),
                ) {
                    Icon(
                        painter = painterResource(id = if (isFavorited) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_outlined),
                        contentDescription = null,
                        tint = if (isFavorited) ZigzagTheme.colors.red500 else ZigzagTheme.colors.black200,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
internal fun HorizontalProductCardPreview() {
    HorizontalProductCard(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth(),
        image = "adsfaesf",
        productName = "[컬러추가][자체제작/3만장돌파][숏/롱] 리고 썸머 와이드 롱 팬츠 -6color",
        storeName = "히니크",
        discountRate = 19,
        price = 47000,
        badgeLabels = listOf("최저가도전", "무료배송"),
        badgeStyls = listOf(BadgeStyle.PINK, BadgeStyle.GRAY),
        isFavorited = true,
        onFavoriteClick = { },
        showMark = true
    )
}

@Preview
@Composable
internal fun HorizontalProductCardPreview2() {
    HorizontalProductCard(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth(),
        image = "adsfaesf",
        productName = "[컬러추가][자체제작/3만장돌파][숏/롱] 리고 썸머 와이드 롱 팬츠 -6color",
        storeName = "히니크",
        discountRate = 19,
        price = 47000,
        isFavorited = false,
        onFavoriteClick = { },
        showMark = false
    )
}