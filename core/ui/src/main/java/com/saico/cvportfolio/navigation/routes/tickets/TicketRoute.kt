package com.saico.cvportfolio.navigation.routes.tickets

import com.saico.cvportfolio.navigation.routes.Route
import com.saico.cvportfolio.navigation.routes.home.HomeRoute

sealed interface TicketRoute : Route {

    data object RootRoute: TicketRoute{
        override val analyticsTag = "ticket-flow"
        override val route = "ticket"
    }

    data object TicketScreenRoute : TicketRoute {
        override val analyticsTag = "ticket-screen-flow"
        override val route = "ticket/ticket-screen"
    }
}