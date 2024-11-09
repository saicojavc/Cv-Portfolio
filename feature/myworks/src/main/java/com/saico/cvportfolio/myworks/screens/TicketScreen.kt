package com.saico.cvportfolio.myworks.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.saico.cvportfolio.navigation.routes.home.HomeRoute
import com.saico.cvportfolio.ui.AppContent
import com.saico.cvportfolio.ui.R

@Composable
fun TicketScreen(
    navController: NavHostController
) {
    val ticketPhoto = listOf(
        R.drawable.t1,
        R.drawable.t2,
        R.drawable.t3,
        R.drawable.t4,
        R.drawable.t5,
        R.drawable.t6,
        R.drawable.t7,
        R.drawable.t8,
        R.drawable.t9,
        R.drawable.t10,
        R.drawable.t11,
        R.drawable.t12,
        R.drawable.t13,
        R.drawable.t14,
        R.drawable.t15,
        R.drawable.t16,
    )
    val appLogo = R.drawable.ticket_header_logo_blue_2
    val appDescription = R.string.whole_information

    AppContent(
        appPhoto = ticketPhoto,
        logoApp = appLogo,
        textDescription = appDescription,
        onClick = {
            navController.navigate(
                HomeRoute.HomeScreenRoute.route
            )
        }
    )
}
