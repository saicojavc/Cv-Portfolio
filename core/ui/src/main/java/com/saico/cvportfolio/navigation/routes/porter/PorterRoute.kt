package com.saico.cvportfolio.navigation.routes.porter

import com.saico.cvportfolio.navigation.routes.Route

sealed interface PorterRoute : Route {

    data object RootRoute : PorterRoute {
        override val analyticsTag = "porter-flow"
        override val route = "porter"
    }

    data object PorterScreenRoute : PorterRoute {
        override val analyticsTag = "porter-screen-flow"
        override val route = "porter/porter-screen"
    }
}