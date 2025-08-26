package com.dokarun.zigzag.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dokarun.zigzag.R
import com.dokarun.zigzag.ui.theme.ZigzagTheme

@Composable
internal fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding(),
        color = ZigzagTheme.colors.white
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            HorizontalDivider(
                thickness = 0.8.dp,
                color = ZigzagTheme.colors.black100
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                content()
            }
        }
    }
}

@Composable
internal fun BottomNavigationBarItem(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    label: String,
    onClick: () -> Unit,
    @DrawableRes selectedIcon: Int,
    @DrawableRes unselectedIcon: Int,
) {
    Surface(
        modifier = modifier,
        onClick = onClick,
        color = Color.Transparent,
        interactionSource = NoRippleInteractionSource()
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Icon(
                painter = painterResource(id = if (isSelected) selectedIcon else unselectedIcon),
                contentDescription = label,
                tint = ZigzagTheme.colors.black700,
                modifier = Modifier.size(24.dp)
            )
            Text(
                label,
                style = ZigzagTheme.typography.labelSmall,
                color = ZigzagTheme.colors.black700
            )
        }
    }
}

@Preview
@Composable
internal fun BottomNavigationBarPreview() {
    BottomNavigationBar {
        BottomNavigationBarItem(
            modifier = Modifier.weight(1f),
            isSelected = true,
            label = "홈",
            onClick = {},
            selectedIcon = R.drawable.ic_home_filled,
            unselectedIcon = R.drawable.ic_home_outlined
        )
        BottomNavigationBarItem(
            modifier = Modifier.weight(1f),
            isSelected = false,
            label = "스토어",
            onClick = {},
            selectedIcon = R.drawable.ic_store_filled,
            unselectedIcon = R.drawable.ic_store_outlined
        )
        BottomNavigationBarItem(
            modifier = Modifier.weight(1f),
            isSelected = false,
            label = "카테고리",
            onClick = {},
            selectedIcon = R.drawable.ic_menu_filled,
            unselectedIcon = R.drawable.ic_menu_outlined
        )
        BottomNavigationBarItem(
            modifier = Modifier.weight(1f),
            isSelected = false,
            label = "찜",
            onClick = {},
            selectedIcon = R.drawable.ic_favorite_filled,
            unselectedIcon = R.drawable.ic_favorite_outlined
        )
        BottomNavigationBarItem(
            modifier = Modifier.weight(1f),
            isSelected = false,
            label = "마이페이지",
            onClick = {},
            selectedIcon = R.drawable.ic_profile_filled,
            unselectedIcon = R.drawable.ic_profile_outlined
        )
    }
}