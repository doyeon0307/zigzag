package com.dokarun.zigzag.ui.domain.model

import com.dokarun.zigzag.ui.component.BadgeStyle
import com.dokarun.zigzag.ui.component.StickerStyle

data class ProductUiModel(
    val id: Int,
    val image: String,
    val productName: String,
    val storeName: String,
    val discountRate: Int?,
    val price: Int,
    val rating: Float?,
    val reviewCount: Int?,
    val viewCount: Int?,
    val stickerLabel: String?,
    val stickerStyle: StickerStyle?,
    val badgeLabels: List<String>?,
    val badgeStyls: List<BadgeStyle>?,
    val isFavorited: Boolean,
    val isMarked: Boolean,
)