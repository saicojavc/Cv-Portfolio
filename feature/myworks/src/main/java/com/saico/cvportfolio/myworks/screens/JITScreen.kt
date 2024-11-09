package com.saico.cvportfolio.myworks.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.saico.cvportfolio.navigation.routes.home.HomeRoute
import com.saico.cvportfolio.ui.AppContent
import com.saico.cvportfolio.ui.R

@Composable
fun JitScreen(
    navController: NavHostController
) {
    val crmPhoto = listOf(
        R.drawable.crm1,
        R.drawable.crm2,
        R.drawable.crm3,
        R.drawable.crm4,
        R.drawable.crm5,
        R.drawable.crm6,
        R.drawable.crm7,
        R.drawable.crm8,
    )
    val appLogo = R.drawable.undraw_order_ride_re_372k
    val appDescription = R.string.crm_information

    AppContent(
        appPhoto = crmPhoto,
        logoApp = appLogo,
        textDescription = appDescription,
        onClick = {
            navController.navigate(
                HomeRoute.HomeScreenRoute.route
            )
        }
    )

}

