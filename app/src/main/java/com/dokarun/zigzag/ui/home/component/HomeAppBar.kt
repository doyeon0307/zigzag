package com.dokarun.zigzag.ui.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dokarun.zigzag.R
import com.dokarun.zigzag.ui.component.NoRippleInteractionSource
import com.dokarun.zigzag.ui.component.TextLogo
import com.dokarun.zigzag.ui.theme.ZigzagTheme

@Preview
@Composable
internal fun HomeAppBar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextLogo()
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HomeAppBarIcon(
                onClick = {},
                icon = R.drawable.ic_dollar
            )
            HomeAppBarIcon(
                onClick = {},
                icon = R.drawable.ic_search
            )
            HomeAppBarIcon(
                onClick = {},
                icon = R.drawable.ic_shopping_bag
            )
        }
    }
}

@Composable
internal fun HomeAppBarIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    @DrawableRes icon: Int,
) {
    Surface(
        modifier = modifier.size(24.dp),
        onClick = onClick,
        interactionSource = NoRippleInteractionSource(),
        color = Color.Transparent
    ) {
        Icon(
            painter = painterResource(id = icon),
            tint = ZigzagTheme.colors.black700,
            contentDescription = null,
        )
    }
}