@file:Suppress("INFERRED_TYPE_VARIABLE_INTO_EMPTY_INTERSECTION_WARNING")

package com.saico.cvportfolio.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.saico.cvportfolio.home.model.BottomAppBarItem
import com.saico.cvportfolio.home.screen.MainAboutMeScreen
import com.saico.cvportfolio.home.screen.MainContactScreen
import com.saico.cvportfolio.home.screen.MainCurriculumScreen
import com.saico.cvportfolio.home.screen.MainMyWorksScreen
import com.saico.cvportfolio.ui.component.CVPNavigationBar
import com.saico.cvportfolio.ui.component.CVPNavigationBarItem
import com.saico.cvportfolio.ui.component.CVPText
import com.saico.cvportfolio.ui.R
import com.saico.cvportfolio.ui.icon.CVPIcons

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel(),
) {

    Content(
        navigateTo = viewModel::navigateTo,
    )
}

@Composable
fun Content(
    navigateTo: (String) -> Unit,
) {

    var selectedBottomAppBarItem by remember { mutableStateOf(BottomAppBarItem.ABOUTME) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            CVPNavigationBar(
                modifier = Modifier.fillMaxWidth(),
                containerColor = MaterialTheme.colorScheme.background,
                tonalElevation = 0.dp,
                content = {
                    CVPNavigationBarItem(
                        isSelected = selectedBottomAppBarItem == BottomAppBarItem.ABOUTME,
                        label = {
                            CVPText(
                                text = stringResource(R.string.about_me)
                            )
                        },
                        icon = CVPIcons.PersonIcon,
                        contentDescription = stringResource(id = R.string.about_me),
                        onClick = {
                            selectedBottomAppBarItem = BottomAppBarItem.ABOUTME
                        }
                    )
                    CVPNavigationBarItem(
                        isSelected = selectedBottomAppBarItem == BottomAppBarItem.MYWORKS,
                        label = {
                            CVPText(
                                text = stringResource(R.string.portfolio)
                            )
                        },
                        icon = CVPIcons.Dashboard,
                        contentDescription = stringResource(id = R.string.portfolio),
                        onClick = {
                            selectedBottomAppBarItem = BottomAppBarItem.MYWORKS
                        }
                    )
                    CVPNavigationBarItem(
                        isSelected = selectedBottomAppBarItem == BottomAppBarItem.CURRICULUM,
                        label = {
                            CVPText(
                                text = stringResource(R.string.curriculum)
                            )
                        },
                        icon = CVPIcons.Document,
                        contentDescription = stringResource(id = R.string.curriculum),
                        onClick = {
                            selectedBottomAppBarItem = BottomAppBarItem.CURRICULUM
                        }
                    )

                    CVPNavigationBarItem(
                        isSelected = selectedBottomAppBarItem == BottomAppBarItem.CONTACT,
                        label = {
                            CVPText(
                                text = stringResource(R.string.contact_me)
                            )
                        },
                        icon = CVPIcons.ContactMail,
                        contentDescription = stringResource(id = R.string.about_me),
                        onClick = {
                            selectedBottomAppBarItem = BottomAppBarItem.CONTACT
                        }
                    )
                }
            )
        }
    ) { paddingValues ->

        Row {
            when (selectedBottomAppBarItem) {
                BottomAppBarItem.ABOUTME -> {
                    MainAboutMeScreen(
                        navigateTo = navigateTo ,
                        modifier = Modifier.padding(paddingValues)
                    )
                }

                BottomAppBarItem.MYWORKS -> {
                    MainMyWorksScreen(
                        navigateTo = navigateTo ,
                        modifier = Modifier.padding(paddingValues)
                    )
                }

                BottomAppBarItem.CURRICULUM -> {
                    MainCurriculumScreen(
                        modifier = Modifier.padding(paddingValues)
                    )
                }

                BottomAppBarItem.CONTACT -> {
                    MainContactScreen(
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }

    }
}

