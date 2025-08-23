package com.dokarun.zigzag

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import com.dokarun.zigzag.ui.category.categoryGraph
import com.dokarun.zigzag.ui.comopnent.BottomNavigationBar
import com.dokarun.zigzag.ui.comopnent.BottomNavigationBarItem
import com.dokarun.zigzag.ui.favorite.favoriteGraph
import com.dokarun.zigzag.ui.home.homeGraph
import com.dokarun.zigzag.ui.mypage.mypageGraph
import com.dokarun.zigzag.ui.store.storeGraph
import com.dokarun.zigzag.ui.theme.ZigzagTheme

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZigzagNavHost(appState: ZigzagAppState) {
    val navController = appState.navController

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            Surface(
                color = ZigzagTheme.colors.white
            ) {
                AnimatedVisibility(
                    visible = appState.shouldShowBottomBar,
                    enter = slideInVertically { it },
                    exit = slideOutVertically { it },
                ) {
                    ZigzagBottomNavigationBar(
                        destinations = appState.topLevelDestinations,
                        currentDestination = appState.currentDestination,
                        onNavigateToDestination = { destination ->
                            appState.navigateToTopLevelDestination(destination)
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Routes.Home.ROUTE,
            modifier = Modifier.padding(paddingValues),
        ) {
            homeGraph()
            storeGraph()
            categoryGraph()
            favoriteGraph()
            mypageGraph()
        }
    }
}

@Composable
private fun ZigzagBottomNavigationBar(
    destinations: List<TopLevelDestination>,
    currentDestination: NavDestination?,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
) {
    BottomNavigationBar {
        destinations.forEach { destination ->
            val isSelected = currentDestination.isTopLevelDestinationInHierarchy(destination)

            BottomNavigationBarItem(
                modifier = Modifier.weight(1f),
                label = destination.label,
                isSelected = isSelected,
                selectedIcon = destination.selectedIcon,
                unselectedIcon = destination.unselectedIcon,
                onClick = { onNavigateToDestination(destination) }
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.route, true) == true
    } == true