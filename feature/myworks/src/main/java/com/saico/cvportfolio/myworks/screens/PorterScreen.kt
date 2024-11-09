package com.saico.cvportfolio.myworks.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.saico.cvportfolio.navigation.routes.home.HomeRoute
import com.saico.cvportfolio.ui.AppContent
import com.saico.cvportfolio.ui.R

@Composable
fun PorterScreen(
    navController: NavHostController
) {
    val porterPhoto = listOf(
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3,
        R.drawable.p4,
        R.drawable.p5,
        R.drawable.p6,
        R.drawable.p7,
    )
    val appLogo = R.drawable.porter
    val appDescription = R.string.porter_information

    AppContent(
        appPhoto = porterPhoto,
        logoApp = appLogo,
        textDescription = appDescription,
        onClick = {
            navController.navigate(
                HomeRoute.HomeScreenRoute.route
            )
        }
    )
}

