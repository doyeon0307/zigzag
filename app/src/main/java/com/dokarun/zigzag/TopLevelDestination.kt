package com.dokarun.zigzag

import androidx.annotation.DrawableRes
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy

enum class TopLevelDestination(
    val label: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val route: String,
) {
    Home(
        label = "홈",
        selectedIcon = R.drawable.ic_home_filled,
        unselectedIcon = R.drawable.ic_home_outlined,
        route = Routes.Home.ROUTE
    ),
    Store(
        label = "스토어",
        selectedIcon = R.drawable.ic_store_filled,
        unselectedIcon = R.drawable.ic_store_outlined,
        route = Routes.Store.ROUTE
    ),
    Category(
        label = "카테고리",
        selectedIcon = R.drawable.ic_menu_filled,
        unselectedIcon = R.drawable.ic_menu_outlined,
        route = Routes.Category.ROUTE
    ),
    Favorite(
        label = "찜",
        selectedIcon = R.drawable.ic_favorite_filled,
        unselectedIcon = R.drawable.ic_favorite_outlined,
        route = Routes.Favorite.ROUTE
    ),
    Mypage(
        label = "마이페이지",
        selectedIcon = R.drawable.ic_profile_filled,
        unselectedIcon = R.drawable.ic_profile_outlined,
        route = Routes.Mypage.ROUTE
    )
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.route, true) == true
    } == true