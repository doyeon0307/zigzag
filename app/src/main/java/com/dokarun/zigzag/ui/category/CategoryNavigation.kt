package com.dokarun.zigzag.ui.category

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dokarun.zigzag.Routes

fun NavGraphBuilder.categoryGraph() {
    composable(
        route = Routes.Category.ROUTE
    ) {
        CategoryScreen()
    }
}