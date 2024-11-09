package com.saico.cvportfolio.navigation.routes.jit

import com.saico.cvportfolio.navigation.routes.Route

sealed interface JitRoute : Route {

    data object RootRoute : JitRoute {
        override val analyticsTag = "jit-flow"
        override val route = "jit"
    }

    data object JitScreenRoute : JitRoute {
        override val analyticsTag = "jit-screen-flow"
        override val route = "jit/jit-screen"
    }
}