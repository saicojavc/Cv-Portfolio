package com.saico.cvportfolio.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saico.cvportfolio.home.model.HomeUIState
import com.saico.cvportfolio.navigation.NavigationCommand
import com.saico.cvportfolio.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigator: Navigator,
): ViewModel() {

    private val _uiState: MutableStateFlow<HomeUIState> = MutableStateFlow(HomeUIState())
    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow()


    fun navigateTo(route: String) {
        navigator.navigate(
            NavigationCommand.NavigateTo(
                route
            )
        )
    }

    fun onSubjectChanged(value: String) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    subject = value,
                )
            }
        }
    }
    fun onContentChanged(value: String) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    content = value,
                )
            }
        }
    }
}


