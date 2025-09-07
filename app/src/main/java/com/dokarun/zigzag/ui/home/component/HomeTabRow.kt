package com.dokarun.zigzag.ui.home.component

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dokarun.zigzag.ui.theme.ZigzagTheme

@Composable
internal fun HomeTabRow(
    modifier: Modifier = Modifier,
    tabLabels: List<String>,
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit,
) {
    LazyRow(
        modifier = modifier
    ) {
        itemsIndexed(tabLabels) { index, label ->
            TabItem(
                label = label,
                isSelected = index == selectedTabIndex,
                onClick = { onTabClick(index) },
                selectedColor = if (index == 0) ZigzagTheme.colors.white else null,
                unselectedColor = if (index == 0) ZigzagTheme.colors.navy500 else null,
            )
        }
    }
}