package com.dokarun.zigzag.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dokarun.zigzag.ui.component.Chip

@Composable
internal fun HomeCategoryRow(
    modifier: Modifier = Modifier,
    categoryLabels: List<String>,
    selectedCategoryIndex: Int,
    onCategoryClick: (Int) -> Unit,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        itemsIndexed(categoryLabels) { index, label ->
            Chip(
                modifier = Modifier.padding(
                    start = if (index == 0) 16.dp else 0.dp,
                    end = if (index == categoryLabels.size - 1) 16.dp else 0.dp
                ),
                label = label,
                isSelected = index == selectedCategoryIndex,
                onClick = { onCategoryClick(index) },
            )
        }
    }
}