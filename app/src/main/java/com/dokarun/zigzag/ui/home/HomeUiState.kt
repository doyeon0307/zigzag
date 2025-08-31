package com.dokarun.zigzag.ui.home

import com.dokarun.zigzag.ui.domain.model.MainBannerUiModel
import com.dokarun.zigzag.ui.domain.model.ProductUiModel
import com.dokarun.zigzag.ui.domain.model.QuickMenuUiModel
import com.dokarun.zigzag.ui.domain.model.SeasonSectionUiModel
import com.dokarun.zigzag.ui.domain.model.WeeklyVoteUiModel
import com.dokarun.zigzag.ui.home.const.HomeCategoryTab
import com.dokarun.zigzag.ui.home.const.HomeTab
import java.time.LocalDateTime

data class HomeUiState(
    val userName: String = "",
    val selectedTabIndex: Int = 1,
    val tabLabels: List<String> = HomeTab.entries.map { it.title },
    val mainBanners: List<MainBannerUiModel> = emptyList<MainBannerUiModel>(),
    val quickMenus: List<QuickMenuUiModel> = emptyList<QuickMenuUiModel>(),
    val selectedCategoryIndex: Int = 0,
    val categoryLabels: List<String> = HomeCategoryTab.entries.map { it.title },
    val allCategoryProducts: List<ProductUiModel> = emptyList<ProductUiModel>(),
    val categoryProducts: List<ProductUiModel> = emptyList<ProductUiModel>(),
    val weeklyVote: WeeklyVoteUiModel? = null,
    val selectedVoteItemId: Int? = null,
    val popularProducts: List<ProductUiModel> = emptyList<ProductUiModel>(),
    val seasonSectionTitle: String = "",
    val seasonItemList: List<SeasonSectionUiModel> = emptyList<SeasonSectionUiModel>(),
    val discountSectionTitle: String = "",
    val discountProducts: List<ProductUiModel> = emptyList<ProductUiModel>(),
    val eventTitle: String = "",
    val eventEndDateTime: LocalDateTime? = null,
    val remainingHour: String = "",
    val remainingMinute: String = "",
    val remainingSecond: String = "",
    val eventProducts: List<ProductUiModel> = emptyList<ProductUiModel>(),
)
