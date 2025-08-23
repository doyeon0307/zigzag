package com.dokarun.zigzag.ui.store

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dokarun.zigzag.Routes

fun NavGraphBuilder.storeGraph() {
    composable(
        route = Routes.Store.ROUTE
    ) {
        StoreScreen()
    }
}