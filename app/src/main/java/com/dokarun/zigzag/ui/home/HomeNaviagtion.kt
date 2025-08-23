package com.dokarun.zigzag.ui.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dokarun.zigzag.Routes

fun NavGraphBuilder.homeGraph() {
    composable(
        route = Routes.Home.ROUTE
    ) {
        HomeScreen()
    }
}