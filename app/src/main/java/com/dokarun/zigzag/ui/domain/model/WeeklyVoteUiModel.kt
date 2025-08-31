package com.dokarun.zigzag.ui.domain.model

data class WeeklyVoteUiModel(
    val id: Int,
    val title: String,
    val smallReward: String,
    val smallRewardCondition: String,
    val bigReward: String,
    val bigRewardCondition: String,
    val voteItemList: List<VoteItemUiModel>,
    )

data class VoteItemUiModel(
    val id: Int,
    val image: String?,
    val content: String,
)