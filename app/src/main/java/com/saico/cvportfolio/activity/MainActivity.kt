package com.saico.cvportfolio.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.saico.cvportfolio.home.navigation.homeGraph
import com.saico.cvportfolio.myworks.navigation.jitGraph
import com.saico.cvportfolio.myworks.navigation.porterGraph
import com.saico.cvportfolio.myworks.navigation.ticketGraph
import com.saico.cvportfolio.navigation.Navigator
import com.saico.cvportfolio.navigation.NavigatorHandler
import com.saico.cvportfolio.splash.SplashScreen
import com.saico.cvportfolio.ui.theme.CVPortfolioTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
//        enableEdgeToEdge()
        setContent {

            var showSplashScreen by remember { mutableStateOf(true) }
//            val theme by viewModel.theme.collectAsStateWithLifecycle(initialValue = CVPSystemTheme.System)
            val systemTheme = isSystemInDarkTheme()
            val context = LocalContext.current

            LaunchedEffect(Unit) {
                delay(3000) // Espera 3 segundos
                showSplashScreen = false
            }
//            val darkTheme by remember {
//                derivedStateOf {
//                    when (theme) {
//                        CVPSystemTheme.Light -> false
//                        CVPSystemTheme.Dark -> true
//                        CVPSystemTheme.System -> systemTheme
//                    }
//                }
//            }

            CVPortfolioTheme(
                darkTheme = false
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.surface
                ) {

                    if (showSplashScreen) {

                        SplashScreen()
                    } else {
                        MainContainer(
                            startDestination = viewModel.firstScreen, navigator = navigator
                        )
                    }
                }
            }
        }
    }

}

@Composable
private fun MainContainer(
    startDestination: String, navigator: Navigator,
) {
    val navController = rememberNavController()



    Column {
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.weight(1.0f)
        ) {

            homeGraph(navController)

            ticketGraph(navController)

            jitGraph(navController)

            porterGraph(navController)


        }
    }

    //Listener of the Navigator
    NavigatorHandler(navigator = navigator, navController = navController)
}