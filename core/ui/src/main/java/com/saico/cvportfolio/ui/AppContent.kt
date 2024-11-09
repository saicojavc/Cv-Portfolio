package com.saico.cvportfolio.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.saico.cvportfolio.theme.FontSizes
import com.saico.cvportfolio.theme.PaddingDim
import com.saico.cvportfolio.ui.component.CVPElevatedCard
import com.saico.cvportfolio.ui.component.CVPText
import com.saico.cvportfolio.ui.component.CVPTooltipIconButton
import com.saico.cvportfolio.ui.component.FullScreenImage
import com.saico.cvportfolio.ui.component.PhotoGallery
import com.saico.cvportfolio.ui.icon.CVPIcons

@Composable
fun AppContent(appPhoto: List<Int>, logoApp: Int, textDescription: Int, onClick: () -> Unit) {

    val (expanded, onExpand) = remember {
        mutableStateOf(false)
    }

    var selectedPhoto by remember { mutableStateOf<Int?>(null) }

    Scaffold(
        topBar = {
            CVPTooltipIconButton(
                contentDescription = "",
                tooltipMsg = stringResource(id = R.string.onBack),
                icon = CVPIcons.OnBackIcon,
                onClick = onClick
            )

        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            item {
                Image(
                    painter = painterResource(id = logoApp),
                    contentDescription = "jit header logo",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = PaddingDim.VERY_LARGE),
//                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                )
            }
            item {
                CVPElevatedCard(
                    modifier = Modifier
                        .padding(PaddingDim.SMALL)
                        .clickable { onExpand(!expanded) }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(PaddingDim.SMALL)
                            .padding(bottom = PaddingDim.MEDIUM),
                        verticalArrangement = Arrangement.spacedBy(PaddingDim.SMALL)
                    ) {
                        CVPText(
                            text = stringResource(id = textDescription),
                            maxLines = if (expanded) Int.MAX_VALUE else 3,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .padding(PaddingDim.SMALL)
                                .animateContentSize(
                                    spring(
                                        Spring.DampingRatioLowBouncy,
                                        Spring.StiffnessLow
                                    )
                                )
                        )
                    }
                }
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    CVPText(
                        modifier = Modifier.padding(PaddingDim.MEDIUM),
                        text = stringResource(id = R.string.gallery),
                        fontSize = FontSizes.TITLE_BIG,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            item {
                if (selectedPhoto != null) {
                    FullScreenImage(selectedPhoto!!) {
                        selectedPhoto = null
                    }
                } else {
                    PhotoGallery(
                        appPhoto
                    ) { photoId ->
                        selectedPhoto = photoId
                    }
                }
            }
        }
    }

}