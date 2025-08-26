package com.dokarun.zigzag.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.dokarun.zigzag.R
import com.dokarun.zigzag.ui.theme.ZigzagTheme
import com.dokarun.zigzag.util.addComma
import com.dokarun.zigzag.util.toKoreanCompact

@Composable
internal fun VerticalProductCard(
    modifier: Modifier = Modifier,
    size: VerticalProductCardSize,
    image: String,
    productName: String,
    storeName: String,
    discountRate: Int? = null,
    price: Int,
    rating: Float,
    reviewCount: Int,
    viewCount: Int? = null,
    stickerLabel: String? = null,
    stickerStyle: StickerStyle? = null,
    badgeLabels: List<String>? = null,
    badgeStyls: List<BadgeStyle>? = null,
    isFavorited: Boolean,
    onFavoriteClick: () -> Unit,
    showMark: Boolean,
    showMore: Boolean,
) {
    Surface(
        modifier = modifier,
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(5f / 6f)
            ) {
                AsyncImage(
                    model = image,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                if (stickerLabel != null && stickerStyle != null) {
                    Sticker(
                        modifier = Modifier.align(Alignment.BottomStart),
                        label = stickerLabel,
                        stickerStyle = stickerStyle
                    )
                }
                Surface(
                    modifier = Modifier
                        .size(size.sizeValues().iconSize)
                        .align(Alignment.BottomEnd)
                        .padding(size.sizeValues().iconPadding),
                    color = Color.Transparent,
                    onClick = onFavoriteClick,
                    interactionSource = NoRippleInteractionSource(),
                ) {
                    Icon(
                        painter = painterResource(id = if (isFavorited) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_outlined),
                        contentDescription = null,
                        tint = if (isFavorited) ZigzagTheme.colors.red500 else ZigzagTheme.colors.white,
                    )
                }
            }
            Box(
                modifier = Modifier.padding(
                    start = size.sizeValues().startPadding,
                    end = size.sizeValues().endPadding,
                    top = size.sizeValues().topPadding,
                    bottom = size.sizeValues().bottomPadding,
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(2.dp),
                                verticalAlignment = Alignment.CenterVertically
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
                            if (showMore && size != VerticalProductCardSize.SMALL) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_more),
                                    tint = ZigzagTheme.colors.black200,
                                    contentDescription = null,
                                )
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
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star_filled),
                            contentDescription = null,
                            tint = ZigzagTheme.colors.black300
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                rating.toString(),
                                style = ZigzagTheme.typography.labelMedium,
                                color = ZigzagTheme.colors.black300,
                            )
                            Text(
                                "(${reviewCount.addComma()})",
                                style = ZigzagTheme.typography.bodySmall,
                                color = ZigzagTheme.colors.black300,
                            )
                        }
                        if (viewCount != null && size != VerticalProductCardSize.SMALL) {
                            Text(
                                "• ${viewCount.toKoreanCompact()} 번 봤어요",
                                style = ZigzagTheme.typography.bodySmall,
                                color = ZigzagTheme.colors.black300,
                            )
                        }
                    }
                }
            }
        }
    }
}

data class VerticalProductCardValues(
    val startPadding: Dp,
    val endPadding: Dp,
    val topPadding: Dp,
    val bottomPadding: Dp,
    val iconSize: Dp,
    val iconPadding: Dp,
)

enum class VerticalProductCardSize {
    LARGE,
    SMALL;

    @Composable
    fun sizeValues(): VerticalProductCardValues = when (this) {
        LARGE -> VerticalProductCardValues(
            startPadding = 8.dp,
            endPadding = 8.dp,
            topPadding = 12.dp,
            bottomPadding = 20.dp,
            iconSize = 32.dp,
            iconPadding = 8.dp
        )

        SMALL -> VerticalProductCardValues(
            startPadding = 4.dp,
            endPadding = 4.dp,
            topPadding = 8.dp,
            bottomPadding = 16.dp,
            iconSize = 24.dp,
            iconPadding = 4.dp
        )
    }
}

@Preview
@Composable
internal fun VerticalProductCardLargePreview() {
    VerticalProductCard(
        modifier = Modifier.width(200.dp),
        size = VerticalProductCardSize.LARGE,
        image = "akjdfja",
        productName = "[컬러추가][자체제작/3만장돌파][숏/롱] 리고 썸머 와이드 롱 팬츠 -6color",
        storeName = "히니크",
        discountRate = 19,
        price = 47600,
        rating = 4.8f,
        reviewCount = 3721,
        viewCount = 98298,
        stickerLabel = "직진배송",
        stickerStyle = StickerStyle.PURPLE,
        badgeLabels = listOf("최저가도전", "무료배송"),
        badgeStyls = listOf(BadgeStyle.PINK, BadgeStyle.GRAY),
        isFavorited = true,
        onFavoriteClick = {},
        showMark = true,
        showMore = true
    )
}

@Preview
@Composable
internal fun VerticalProductCardSmallPreview() {
    VerticalProductCard(
        modifier = Modifier.width(120.dp),
        size = VerticalProductCardSize.SMALL,
        image = "akjdfja",
        productName = "[컬러추가][자체제작/3만장돌파][숏/롱] 리고 썸머 와이드 롱 팬츠 -6color",
        storeName = "히니크",
        discountRate = 19,
        price = 47600,
        rating = 4.8f,
        reviewCount = 3721,
        viewCount = 987,
        stickerLabel = "직진배송",
        stickerStyle = StickerStyle.PURPLE,
        badgeLabels = listOf("최저가도전", "무료배송"),
        badgeStyls = listOf(BadgeStyle.PINK, BadgeStyle.GRAY),
        isFavorited = true,
        onFavoriteClick = {},
        showMark = false,
        showMore = true
    )
}