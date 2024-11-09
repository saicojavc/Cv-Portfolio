package com.saico.cvportfolio.myworks.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.saico.cvportfolio.myworks.screens.JitScreen
import com.saico.cvportfolio.myworks.screens.PorterScreen
import com.saico.cvportfolio.navigation.routes.jit.JitRoute
import com.saico.cvportfolio.navigation.routes.porter.PorterRoute

fun NavGraphBuilder.porterGraph(navController: NavHostController) {
    navigation(
        startDestination = PorterRoute.PorterScreenRoute.route,
        route = PorterRoute.RootRoute.route
    ) {
        composable(route = PorterRoute.PorterScreenRoute.route) {
            PorterScreen(navController)
        }
    }
}