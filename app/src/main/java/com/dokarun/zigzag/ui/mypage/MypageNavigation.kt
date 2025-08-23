package com.dokarun.zigzag.ui.mypage

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dokarun.zigzag.Routes

fun NavGraphBuilder.mypageGraph() {
    composable(
        route = Routes.Mypage.ROUTE
    ) {
        MypageScreen()
    }
}