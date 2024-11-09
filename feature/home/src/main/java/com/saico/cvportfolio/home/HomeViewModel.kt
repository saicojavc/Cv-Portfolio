package com.saico.cvportfolio.home

import androidx.lifecycle.ViewModel
import com.saico.cvportfolio.navigation.NavigationCommand
import com.saico.cvportfolio.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigator: Navigator,
): ViewModel() {


    fun navigateTo(route: String) {
        navigator.navigate(
            NavigationCommand.NavigateTo(
                route
            )
        )
    }
}