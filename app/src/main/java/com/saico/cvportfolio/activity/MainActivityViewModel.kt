package com.saico.cvportfolio.activity

import androidx.lifecycle.ViewModel
import com.saico.cvportfolio.domain.usescases.settings.GetSystemThemeUseCase
import com.saico.cvportfolio.navigation.routes.home.HomeRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class MainActivityViewModel  @Inject constructor(
//     getSystemThemeUseCase: GetSystemThemeUseCase
): ViewModel() {

//    val theme = getSystemThemeUseCase()

    var firstScreen = HomeRoute.RootRoute.route
}