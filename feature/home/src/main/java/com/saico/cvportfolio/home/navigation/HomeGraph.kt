package com.saico.cvportfolio.home.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.saico.cvportfolio.home.HomeScreen
import com.saico.cvportfolio.navigation.routes.home.HomeRoute

fun NavGraphBuilder.homeGraph(navController: NavHostController) {
    navigation(
        startDestination = HomeRoute.HomeScreenRoute.route,
        route = HomeRoute.RootRoute.route
    ) {
        composable(route = HomeRoute.HomeScreenRoute.route) {
            HomeScreen(navController)
        }
    }
}