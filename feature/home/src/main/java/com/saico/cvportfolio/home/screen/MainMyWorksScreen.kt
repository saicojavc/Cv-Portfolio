package com.saico.cvportfolio.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.saico.cvportfolio.navigation.routes.jit.JitRoute
import com.saico.cvportfolio.navigation.routes.porter.PorterRoute
import com.saico.cvportfolio.navigation.routes.tickets.TicketRoute
import com.saico.cvportfolio.theme.DarkColors
import com.saico.cvportfolio.theme.FontSizes
import com.saico.cvportfolio.theme.PaddingDim
import com.saico.cvportfolio.ui.R
import com.saico.cvportfolio.ui.component.CVPCard
import com.saico.cvportfolio.ui.component.CVPIcon
import com.saico.cvportfolio.ui.component.CVPText
import com.saico.cvportfolio.ui.icon.CVPIcons

@Composable
fun MainMyWorksScreen(
    modifier: Modifier,
    navigateTo: (String) -> Unit,
) {
    ContentWorks(
        navigateTo = navigateTo
    )
}

@Composable
fun ContentWorks(
    navigateTo: (String) -> Unit,
) {

    Scaffold(
        topBar = {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(PaddingDim.EXTRA_LARGE),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                CVPIcon(
                    imageVector = CVPIcons.Dashboard,
                    contentDescription = "",
                    background = Color.Unspecified
                )

                CVPText(
                    text = stringResource(id = R.string.portfolio),
                    fontSize = FontSizes.TITLE
                )
            }
        }
    ) { paddingValues ->

        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .scrollable(state = scrollState, orientation = Orientation.Vertical),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            CVPCard(
                modifier = Modifier
                    .padding(PaddingDim.SMALL)
                    .clickable {
                        navigateTo(
                            TicketRoute.TicketScreenRoute.route
                        )
                    },
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingDim.SMALL),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ticket_icon),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .weight(1f)
                            .padding(PaddingDim.SMALL)
                            .size(100.dp)
                            .background(
                                color = DarkColors.OnSecondary,
                                shape = RoundedCornerShape(PaddingDim.VERY_LARGE)
                            )
//                            .clip(shape = RoundedCornerShape(PaddingDim.VERY_LARGE))
                    )
                    Column(
                        modifier = Modifier.weight(2f),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.ticket_app),
                            fontSize = FontSizes.TITLE,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = stringResource(id = R.string.ticket_description),
                            fontWeight = FontWeight.Bold,
                        )
                    }

                    CVPIcon(
                        modifier = Modifier.weight(0.3f),
                        imageVector = CVPIcons.ArrowNextOutlined,
                        contentDescription = "Description",
                        background = Color.Unspecified
                    )
                }
            }
            CVPCard(
                modifier = Modifier
                    .padding(PaddingDim.SMALL)
                    .clickable {
                        navigateTo(
                            JitRoute.JitScreenRoute.route
                        )
                    },
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingDim.SMALL),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_crm_icon_launcher_foreground),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .weight(1f)
                            .padding(PaddingDim.SMALL)
                            .size(100.dp)
                            .background(
                                color = DarkColors.OnSecondary,
                                shape = RoundedCornerShape(PaddingDim.VERY_LARGE)
                            )
//                            .clip(shape = RoundedCornerShape(PaddingDim.VERY_LARGE))
                    )
                    Column(
                        modifier = Modifier.weight(2f),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.jit_app),
                            fontSize = FontSizes.TITLE,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = stringResource(id = R.string.jit_description),
                            fontWeight = FontWeight.Bold,
                        )
                    }

                    CVPIcon(
                        modifier = Modifier.weight(0.3f),
                        imageVector = CVPIcons.ArrowNextOutlined,
                        contentDescription = "Description",
                        background = Color.Unspecified
                    )
                }
            }

            CVPCard(
                modifier = Modifier
                    .padding(PaddingDim.SMALL)
                    .clickable {
                        navigateTo(
                            PorterRoute.PorterScreenRoute.route
                        )
                    },
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingDim.SMALL),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_porter),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(PaddingDim.SMALL)
                            .weight(1f)
                            .size(100.dp)
                            .background(
                                color = DarkColors.OnSecondary,
                                shape = RoundedCornerShape(PaddingDim.VERY_LARGE)
                            )
//                            .clip(shape = RoundedCornerShape(PaddingDim.VERY_LARGE))
                    )
                    Column(
                        modifier = Modifier.weight(2f),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(id = R.string.porter_app),
                            fontSize = FontSizes.TITLE,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = stringResource(id = R.string.porter_description),
                            fontWeight = FontWeight.Bold
                        )
                    }

                    CVPIcon(
                        modifier = Modifier.weight(0.3f),
                        imageVector = CVPIcons.ArrowNextOutlined,
                        contentDescription = "Description",
                        background = Color.Unspecified
                    )
                }
            }


        }
    }
}
