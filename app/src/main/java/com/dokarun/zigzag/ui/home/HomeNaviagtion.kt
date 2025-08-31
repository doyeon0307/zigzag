package com.dokarun.zigzag.ui.home

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dokarun.zigzag.Routes
import com.dokarun.zigzag.ZigzagAppState

fun NavGraphBuilder.homeGraph(
    appState: ZigzagAppState,
) {
    composable(
        route = Routes.Home.ROUTE
    ) {
        val viewModel: HomeViewModel = hiltViewModel()
        HomeScreen(
            appState = appState,
            viewModel = viewModel
        )
    }
}