package com.dokarun.zigzag.ui.home

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.pager.rememberPagerState
import com.dokarun.zigzag.ZigzagAppState
import com.dokarun.zigzag.ui.component.LargeButton
import com.dokarun.zigzag.ui.component.TextLogo
import com.dokarun.zigzag.ui.component.VerticalProductCard
import com.dokarun.zigzag.ui.component.VerticalProductCardSize
import com.dokarun.zigzag.ui.component.VoteCard
import com.dokarun.zigzag.ui.home.component.HomeCategoryRow
import com.dokarun.zigzag.ui.home.component.HomeTabRow
import com.dokarun.zigzag.ui.home.component.HomeTitle
import com.dokarun.zigzag.ui.home.component.MainBannerHorizontalPager
import com.dokarun.zigzag.ui.home.component.QuickMenu
import com.dokarun.zigzag.ui.home.component.VoteTitle
import com.dokarun.zigzag.ui.theme.ZigzagTheme

@Composable
internal fun HomeScreen(
    appState: ZigzagAppState,
    viewModel: HomeViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()

    val pagerState = rememberPagerState(pageCount = {
        uiState.mainBanners.size
    })

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val largeProductCardWidth = (screenWidth - 2.dp) / 2
    val largeProductCardHeight = largeProductCardWidth * 2

    val context = LocalContext.current

    val listState = rememberLazyListState()

    val showTabFloating by remember<State<Boolean>> {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0
        }
    }

    val showCategoryFloating by remember<State<Boolean>> {
        derivedStateOf {
            listState.firstVisibleItemIndex > 2
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ZigzagTheme.colors.white),
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
        ) {
            // 로고
            // 첫 번째 아이템 > 지나면 플로팅 노출
            item {
                TextLogo(
                    modifier = Modifier.padding(start = 16.dp, top = 20.dp, bottom = 20.dp)
                )
            }
            // 탭
            item {
                HomeTabRow(
                    tabLabels = uiState.tabLabels,
                    selectedTabIndex = uiState.selectedTabIndex,
                    onTabClick = { index -> viewModel.onTabClick(index) }
                )
            }
            // 메인 배너 & 퀵메뉴
            item {
                Column(
                    modifier = Modifier.padding(vertical = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // 메인 배너
                    MainBannerHorizontalPager(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        state = pagerState,
                        banners = uiState.mainBanners,
                        onBannerClick = {}
                    )
                    // 퀵메뉴
                    LazyRow {
                        itemsIndexed(uiState.quickMenus) { index, menu ->
                            QuickMenu(
                                modifier = Modifier.padding(
                                    start = if (index == 0) 16.dp else 0.dp,
                                    end = 16.dp
                                ),
                                image = menu.image,
                                label = menu.title,
                                onClick = {}
                            )
                        }
                    }
                }
            }
            // 추천 상품
            // 추천 아이템 타이틀
            // 두 번째 아이템 > 지나면 플로팅 노출
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 32.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HomeTitle(
                        title = "${uiState.userName}님을 위한 추천 아이템",
                    )
                    Text(
                        "Sponsored",
                        style = ZigzagTheme.typography.labelSmall,
                        color = ZigzagTheme.colors.black200
                    )
                }
            }
            // 카테고리 칩
            item {
                HomeCategoryRow(
                    modifier = Modifier.padding(vertical = 20.dp),
                    categoryLabels = uiState.categoryLabels,
                    selectedCategoryIndex = uiState.selectedCategoryIndex,
                    onCategoryClick = { index -> viewModel.onCategoryClick(index) }
                )
            }
            // 카테고리 전체 선택 시에만 노출되는 구좌
            item {
                if (uiState.selectedCategoryIndex == 0) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp),
                        horizontalArrangement = Arrangement.spacedBy(2.dp)
                    ) {
                        uiState.allCategoryProducts.map { it ->
                            VerticalProductCard(
                                modifier = Modifier.weight(1f),
                                size = VerticalProductCardSize.SMALL,
                                data = it,
                                onFavoriteClick = {},
                            )
                        }
                    }
                }
            }
            // 카테고리별 상품
            item {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .height(largeProductCardHeight * 2)
                        .padding(bottom = 40.dp),
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    userScrollEnabled = false
                ) {
                    items(uiState.categoryProducts) { product ->
                        VerticalProductCard(
                            size = VerticalProductCardSize.LARGE,
                            data = product,
                            showMore = true,
                            onFavoriteClick = {},
                        )
                    }
                }
            }
            // 투표 구좌
            if (uiState.weeklyVote != null) {
                item {
                    Column(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        // 투표 타이틀
                        VoteTitle(
                            title = uiState.weeklyVote!!.title,
                            smallRewardCondition = uiState.weeklyVote!!.smallRewardCondition,
                            smallReward = uiState.weeklyVote!!.smallReward,
                            bigRewardCondition = uiState.weeklyVote!!.bigRewardCondition,
                            bigReward = uiState.weeklyVote!!.bigReward,
                        )
                        // 투표 아이템
                        Column(
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            uiState.weeklyVote!!.voteItemList.map { it ->
                                VoteCard(
                                    modifier = Modifier.fillMaxWidth(),
                                    image = it.image,
                                    label = it.content,
                                    isSelected = it.id == uiState.selectedVoteItemId,
                                    onClick = { viewModel.onVoteItemClick(it.id) }
                                )
                            }
                        }
                        // 투표 버튼
                        LargeButton(
                            label = "상품 선택하고 ${uiState.weeklyVote!!.smallReward} 포인트 받기",
                            onClick = {},
                            isEnabled = uiState.selectedVoteItemId != null,
                            onDisabledClick = {
                                Toast.makeText(
                                    context,
                                    "투표할 아이템을 선택해주세요.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        )
                    }
                }
            }
        }
        Surface(
            color = ZigzagTheme.colors.white,
            shadowElevation = 4.dp,
        ) {
            Column(
                modifier = Modifier.padding(vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                if (showTabFloating) {
                    HomeTabRow(
                        tabLabels = uiState.tabLabels,
                        selectedTabIndex = uiState.selectedTabIndex,
                        onTabClick = { index -> viewModel.onTabClick(index) }
                    )
                }
                if (showCategoryFloating) {
                    HomeCategoryRow(
                        categoryLabels = uiState.categoryLabels,
                        selectedCategoryIndex = uiState.selectedCategoryIndex,
                        onCategoryClick = { index -> viewModel.onCategoryClick(index) }
                    )
                }
            }
        }
    }
}
