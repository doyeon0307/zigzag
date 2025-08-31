package com.dokarun.zigzag.ui.home

import androidx.lifecycle.ViewModel
import com.dokarun.zigzag.ui.component.BadgeStyle
import com.dokarun.zigzag.ui.component.StickerStyle
import com.dokarun.zigzag.ui.domain.model.MainBannerUiModel
import com.dokarun.zigzag.ui.domain.model.ProductUiModel
import com.dokarun.zigzag.ui.domain.model.QuickMenuUiModel
import com.dokarun.zigzag.ui.domain.model.VoteItemUiModel
import com.dokarun.zigzag.ui.domain.model.WeeklyVoteUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        getMainBanners()
        getQuickMenus()
        getUserName()
        getAllCategoryProducts()
        getCategoryProducts(index = 0)
        getWeeklyVoteInfo()
    }

    fun onTabClick(index: Int) {
        _uiState.value = _uiState.value.copy(
            selectedTabIndex = index
        )
    }

    fun onCategoryClick(index: Int) {
        _uiState.value = _uiState.value.copy(
            selectedCategoryIndex = index
        )
        getCategoryProducts(index = index)
    }

    fun onVoteItemClick(id: Int) {
        _uiState.value = _uiState.value.copy(
            selectedVoteItemId = id
        )
    }

    fun getMainBanners() {
        _uiState.value = _uiState.value.copy(
            mainBanners = listOf(
                MainBannerUiModel(
                    id = 1,
                    image = "https://plus.unsplash.com/premium_photo-1756175546675-f55b02bfa6e2?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHwxfHx8ZW58MHx8fHx8",
                ),
                MainBannerUiModel(
                    id = 2,
                    image = "https://images.unsplash.com/photo-1755719985500-b6049b2ecb1f?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHw4fHx8ZW58MHx8fHx8",
                ),
                MainBannerUiModel(
                    id = 3,
                    image = "https://images.unsplash.com/photo-1756149983743-77cdc828f99a?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHwxMnx8fGVufDB8fHx8fA%3D%3D"
                )
            )
        )
    }

    fun getQuickMenus() {
        _uiState.value = _uiState.value.copy(
            quickMenus = listOf(
                QuickMenuUiModel(
                    id = 1,
                    image = "https://plus.unsplash.com/premium_photo-1756276069294-4436d0cf7ccc?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHwyMXx8fGVufDB8fHx8fA%3D%3D",
                    title = "무제한발급",
                ),
                QuickMenuUiModel(
                    id = 2,
                    image = "https://images.unsplash.com/photo-1755930523772-79e4443c9e4a?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHwyN3x8fGVufDB8fHx8fA%3D%3D",
                    title = "테크페스타",
                ),
                QuickMenuUiModel(
                    id = 3,
                    image = "https://plus.unsplash.com/premium_photo-1756131938178-1de1f6d33790?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHwyOXx8fGVufDB8fHx8fA%3D%3D",
                    title = "어바웃톤"
                ),
                QuickMenuUiModel(
                    id = 1,
                    image = "https://plus.unsplash.com/premium_photo-1756276069294-4436d0cf7ccc?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHwyMXx8fGVufDB8fHx8fA%3D%3D",
                    title = "무제한발급",
                ),
                QuickMenuUiModel(
                    id = 2,
                    image = "https://images.unsplash.com/photo-1755930523772-79e4443c9e4a?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHwyN3x8fGVufDB8fHx8fA%3D%3D",
                    title = "테크페스타",
                ),
                QuickMenuUiModel(
                    id = 3,
                    image = "https://plus.unsplash.com/premium_photo-1756131938178-1de1f6d33790?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHwyOXx8fGVufDB8fHx8fA%3D%3D",
                    title = "어바웃톤"
                ),
                QuickMenuUiModel(
                    id = 1,
                    image = "https://plus.unsplash.com/premium_photo-1756276069294-4436d0cf7ccc?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHwyMXx8fGVufDB8fHx8fA%3D%3D",
                    title = "무제한발급",
                ),
                QuickMenuUiModel(
                    id = 2,
                    image = "https://images.unsplash.com/photo-1755930523772-79e4443c9e4a?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHwyN3x8fGVufDB8fHx8fA%3D%3D",
                    title = "테크페스타",
                ),
                QuickMenuUiModel(
                    id = 3,
                    image = "https://plus.unsplash.com/premium_photo-1756131938178-1de1f6d33790?w=900&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHwyOXx8fGVufDB8fHx8fA%3D%3D",
                    title = "어바웃톤"
                ),
            )
        )
    }

    fun getUserName() {
        _uiState.value = _uiState.value.copy(userName = "전도연")
    }

    fun getAllCategoryProducts() {
        _uiState.value = _uiState.value.copy(
            allCategoryProducts = listOf(
                ProductUiModel(
                    id = 1,
                    image = "https://i.pinimg.com/736x/04/29/cb/0429cb94015d57967bba3d622f8e30e0.jpg",
                    productName = "오버핏 기모 후드티",
                    storeName = "어바웃타임",
                    discountRate = 30,
                    price = 49000,
                    rating = 4.6f,
                    reviewCount = 1847,
                    viewCount = 28540,
                    stickerLabel = "HOT",
                    stickerStyle = StickerStyle.PURPLE,
                    badgeLabels = listOf("무료배송", "당일배송"),
                    badgeStyls = listOf(BadgeStyle.GRAY, BadgeStyle.PINK),
                    isFavorited = true,
                    isMarked = true,
                ),
                ProductUiModel(
                    id = 2,
                    image = "https://i.pinimg.com/736x/10/11/c6/1011c6357f28dc731039b98dcee25ba0.jpg",
                    productName = "빈티지 워싱 데님 자켓",
                    storeName = "히니크",
                    discountRate = null,
                    price = 89000,
                    rating = 4.3f,
                    reviewCount = 592,
                    viewCount = 12450,
                    stickerLabel = null,
                    stickerStyle = null,
                    badgeLabels = listOf("신상품"),
                    badgeStyls = listOf(BadgeStyle.PINK),
                    isFavorited = false,
                    isMarked = false,
                ),
                ProductUiModel(
                    id = 3,
                    image = "https://i.pinimg.com/1200x/d5/2b/54/d52b5440cf6d367bbdfd46e6a9834081.jpg",
                    productName = "울 블렌드 니트 스웨터",
                    storeName = "로렐",
                    discountRate = 25,
                    price = 65000,
                    rating = 4.8f,
                    reviewCount = 1203,
                    viewCount = 15820,
                    stickerLabel = "SALE",
                    stickerStyle = StickerStyle.PURPLE,
                    badgeLabels = null,
                    badgeStyls = null,
                    isFavorited = true,
                    isMarked = false,
                ),
            )
        )
    }

    fun getCategoryProducts(index: Int) {
        print("인덱스 $index 카테고리 불러오기")
        _uiState.value = _uiState.value.copy(
            categoryProducts = listOf(
                ProductUiModel(
                    id = 4,
                    image = "https://juliafashionshop.com/cdn/shop/files/Chunky-Knit-Cardigan-for-Women-Cozy-V-neck-Button-Front-Sweater-Jacket-Dusky-Pink-Fall-Winter_5ff67663-c93f-4034-8497-7e10984fceba.webp?v=1727762121&width=1346",
                    productName = "와이드 슬랙스 팬츠",
                    storeName = "데일리룩",
                    discountRate = 15,
                    price = 39900,
                    rating = null,
                    reviewCount = null,
                    viewCount = 8940,
                    stickerLabel = "NEW",
                    stickerStyle = StickerStyle.PURPLE,
                    badgeLabels = listOf("한정특가", "오늘만"),
                    badgeStyls = listOf(BadgeStyle.GRAY, BadgeStyle.GRAY),
                    isFavorited = false,
                    isMarked = true,
                ),
                ProductUiModel(
                    id = 5,
                    image = "https://fashionlaura.com/cdn/shop/files/Elegant-Women-s-Short-Woolen-Coat-Loose-Lapel-Single-Breasted-Long-Sleeve-Pockets-Overcoat-2024-Autumn_ec3d6f23-01f0-4290-9c2e-09f0881edfc2.webp?v=1727410514&width=1346",
                    productName = "크롭 반팔 티셔츠",
                    storeName = "소멸",
                    discountRate = 40,
                    price = 18900,
                    rating = 4.2f,
                    reviewCount = 934,
                    viewCount = 22340,
                    stickerLabel = "HOT",
                    stickerStyle = StickerStyle.PURPLE,
                    badgeLabels = listOf("베스트", "리뷰많은"),
                    badgeStyls = listOf(BadgeStyle.PINK, BadgeStyle.GRAY),
                    isFavorited = true,
                    isMarked = false,
                ),
                ProductUiModel(
                    id = 6,
                    image = "https://i.pinimg.com/736x/ad/b7/25/adb725b57f61f75e95269fbc4f67515a.jpg",
                    productName = "플라워 프린트 미디 원피스",
                    storeName = "비라인",
                    discountRate = null,
                    price = 78000,
                    rating = 4.5f,
                    reviewCount = 658,
                    viewCount = 9870,
                    stickerLabel = null,
                    stickerStyle = null,
                    badgeLabels = listOf("신상품", "추천템"),
                    badgeStyls = listOf(BadgeStyle.PINK, BadgeStyle.GRAY),
                    isFavorited = false,
                    isMarked = true,
                ),
                ProductUiModel(
                    id = 7,
                    image = "https://i.pinimg.com/736x/45/75/d3/4575d313c30e87b071d9e985df5fe515.jpg",
                    productName = "첼시 앵클 부츠",
                    storeName = "말로니",
                    discountRate = 35,
                    price = 128000,
                    rating = 4.7f,
                    reviewCount = 412,
                    viewCount = 5430,
                    stickerLabel = "SALE",
                    stickerStyle = StickerStyle.PURPLE,
                    badgeLabels = null,
                    badgeStyls = null,
                    isFavorited = true,
                    isMarked = false,
                ),
            )
        )
    }

    fun getWeeklyVoteInfo() {
        _uiState.value = _uiState.value.copy(
            weeklyVote = WeeklyVoteUiModel(
                id = 1,
                title = "브랜드 썸머클리어런🌴\n레터프롬문 1위 고르기",
                smallReward = "5",
                smallRewardCondition = "선택만 해도",
                bigReward = "30",
                bigRewardCondition = "1등 예측 성공하면",
                voteItemList = listOf(
                    VoteItemUiModel(
                        id = 1,
                        image = "https://www.stylesock.com/cdn/shop/files/a7c4d087bc5e8f2d1170dc5a03c0609a_1080x.jpg?v=1711534616",
                        content = "몬테 밴딩 블라우스",
                    ),
                    VoteItemUiModel(
                        id = 2,
                        image = "https://i.pinimg.com/1200x/52/8b/7e/528b7ea9ac21535f37f12b312d0bcf60.jpg",
                        content = "클라우 미디 원피스",
                    ),
                    VoteItemUiModel(
                        id = 3,
                        image = "https://i.pinimg.com/1200x/f0/69/36/f0693695d98b5bc242221e11dbc41887.jpg",
                        content = "마가 플라워 맥시 원피스"
                    ),
                    VoteItemUiModel(
                        id = 4,
                        image = "https://i.pinimg.com/736x/fd/fb/fc/fdfbfc251f75d164edd586578339e3ba.jpg",
                        content = "시엘 플리츠 스커트"
                    )
                )
            )
        )
    }
}