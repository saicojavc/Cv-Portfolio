package com.saico.cvportfolio.myworks.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.saico.cvportfolio.myworks.screens.TicketScreen
import com.saico.cvportfolio.navigation.routes.tickets.TicketRoute

fun NavGraphBuilder.ticketGraph(navController: NavHostController) {
    navigation(
        startDestination = TicketRoute.TicketScreenRoute.route,
        route = TicketRoute.RootRoute.route
    ) {
        composable(route = TicketRoute.TicketScreenRoute.route) {
            TicketScreen(navController)
        }
    }
}