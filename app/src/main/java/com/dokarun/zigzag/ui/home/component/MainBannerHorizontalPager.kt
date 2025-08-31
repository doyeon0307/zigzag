package com.dokarun.zigzag.ui.home.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.pager.HorizontalPager
import androidx.wear.compose.foundation.pager.PagerState
import coil3.compose.AsyncImage
import com.dokarun.zigzag.ui.component.NoRippleInteractionSource
import com.dokarun.zigzag.ui.domain.model.MainBannerUiModel

@Composable
internal fun MainBannerHorizontalPager(
    modifier: Modifier = Modifier,
    state: PagerState,
    banners: List<MainBannerUiModel>,
    onBannerClick: () -> Unit,
) {
    HorizontalPager(
        state = state,
        modifier = modifier,
    ) { index ->
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            shape = RoundedCornerShape(10.dp),
            onClick = onBannerClick,
            interactionSource = NoRippleInteractionSource()
        ) {
            AsyncImage(
                model = banners[index].image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}