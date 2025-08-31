package com.dokarun.zigzag.ui.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dokarun.zigzag.ui.theme.ZigzagTheme

@Composable
internal fun VoteTitle(
    modifier: Modifier = Modifier,
    title: String,
    smallRewardCondition: String,
    smallReward: String,
    bigRewardCondition: String,
    bigReward: String,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            title,
            style = ZigzagTheme.typography.titleMedium,
            color = ZigzagTheme.colors.black700
        )
        Row {
            Text(
                smallRewardCondition,
                style = ZigzagTheme.typography.titleSmall,
                color = ZigzagTheme.colors.black700
            )
            Text(
                " ${smallReward}P",
                style = ZigzagTheme.typography.titleSmall,
                color = ZigzagTheme.colors.pink500
            )
            Text(
                " • $bigRewardCondition",
                style = ZigzagTheme.typography.titleSmall,
                color = ZigzagTheme.colors.black700
            )
            Text(
                " ${bigReward}P",
                style = ZigzagTheme.typography.titleSmall,
                color = ZigzagTheme.colors.pink500
            )
        }
    }
}