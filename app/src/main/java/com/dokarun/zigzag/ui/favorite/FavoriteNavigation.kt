package com.dokarun.zigzag.ui.favorite

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dokarun.zigzag.Routes

fun NavGraphBuilder.favoriteGraph() {
    composable(
        route = Routes.Favorite.ROUTE
    ) {
        FavoriteScreen()
    }
}