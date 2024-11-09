package com.saico.cvportfolio.myworks.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.saico.cvportfolio.myworks.screens.JitScreen
import com.saico.cvportfolio.myworks.screens.TicketScreen
import com.saico.cvportfolio.navigation.routes.jit.JitRoute
import com.saico.cvportfolio.navigation.routes.tickets.TicketRoute

fun NavGraphBuilder.jitGraph(navController: NavHostController) {
    navigation(
        startDestination = JitRoute.JitScreenRoute.route,
        route = JitRoute.RootRoute.route
    ) {
        composable(route = JitRoute.JitScreenRoute.route) {
            JitScreen(navController)
        }
    }
}