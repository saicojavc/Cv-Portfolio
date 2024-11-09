package com.saico.cvportfolio.home.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.saico.cvportfolio.home.component.CurriculumTopBar
import com.saico.cvportfolio.theme.FontSizes
import com.saico.cvportfolio.theme.PaddingDim
import com.saico.cvportfolio.ui.R
import com.saico.cvportfolio.ui.component.CVPCard
import com.saico.cvportfolio.ui.component.CVPText
import com.saico.cvportfolio.ui.component.CVPTooltipIconButton
import com.saico.cvportfolio.ui.icon.CVPIcons
import com.saico.cvportfolio.util.formatStringResource

@Composable
fun MainCurriculumScreen(
    modifier: Modifier,
) {
    CurriculumContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurriculumContent() {

    var viewEducation by remember { mutableStateOf(false) }
    var viewHonors by remember { mutableStateOf(false) }


    val (expanded, onExpand) = remember {
        mutableStateOf(false)
    }
    val (expandedE, onExpandE) = remember {
        mutableStateOf(false)
    }

    if (viewEducation) {
        BasicAlertDialog(onDismissRequest = { viewEducation = false },
            content = {
                Image(
                    painter = painterResource(id = R.drawable.titulo),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(PaddingDim.VERY_LARGE))
                )
            })
    }
    if (viewHonors) {
        BasicAlertDialog(onDismissRequest = { viewHonors = false },
            content = {
                Image(
                    painter = painterResource(id = R.drawable.certification),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(PaddingDim.VERY_LARGE))
                )
            })
    }

    val skills = listOf(
        R.string.skills1,
        R.string.skills2,
        R.string.skills3,
        R.string.skills4,
        R.string.skills5,
        R.string.skills6,
        R.string.skills7,
        R.string.skills8,
        R.string.skills9,
        R.string.skills10,
    )

    val experience = listOf(
        R.string.experience_android_developer,
        R.string.experience_intern_web_developer,
        R.string.experience_gtce,
    )

    Scaffold(
        modifier = Modifier.padding(bottom = PaddingDim.GIGANT),
        topBar = {
            CurriculumTopBar()
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CVPText(
                        modifier = Modifier.padding(
                            top = PaddingDim.MEDIUM,
                            bottom = PaddingDim.SMALL
                        ),
                        text = stringResource(id = R.string.summary),
                        fontSize = FontSizes.TITLE_BIG,
                        fontWeight = FontWeight.Bold,

                        )
                    CVPCard(
                        modifier = Modifier
                            .padding(PaddingDim.SMALL)
                            .clickable { onExpand(!expanded) }
                    ) {
                        CVPText(
                            text = stringResource(id = R.string.summary_description),
                            maxLines = if (expanded) Int.MAX_VALUE else 5,
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
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CVPText(
                        modifier = Modifier.padding(
                            top = PaddingDim.MEDIUM,
                            bottom = PaddingDim.SMALL
                        ),
                        text = stringResource(id = R.string.skills),
                        fontSize = FontSizes.TITLE_BIG,
                        fontWeight = FontWeight.Bold,

                        )
                    CVPCard(
                        modifier = Modifier
                            .padding(PaddingDim.SMALL)

                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.Start
                        ) {
                            skills.forEach { skill ->
                                CVPText(
                                    text = stringResource(id = skill),
                                    maxLines = Int.MAX_VALUE,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier
                                        .padding(PaddingDim.SMALL)
                                )
                            }
                        }
                    }
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CVPText(
                        modifier = Modifier.padding(
                            top = PaddingDim.MEDIUM,
                            bottom = PaddingDim.SMALL
                        ),
                        text = stringResource(id = R.string.experience),
                        fontSize = FontSizes.TITLE_BIG,
                        fontWeight = FontWeight.Bold,

                        )
                    CVPCard(
                        modifier = Modifier
                            .padding(PaddingDim.SMALL)
                            .clickable { onExpandE(!expandedE) }
                    ) {
                        experience.forEach { experience ->
                            CVPText(
                                text = formatStringResource(stringResource(id = experience)),
                                maxLines = if (expandedE) Int.MAX_VALUE else 3,
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
                            Spacer(modifier = Modifier.height(PaddingDim.MEDIUM))
                        }

                    }
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CVPText(
                        modifier = Modifier.padding(
                            top = PaddingDim.MEDIUM,
                            bottom = PaddingDim.SMALL
                        ),
                        text = stringResource(id = R.string.education_and_training),
                        fontSize = FontSizes.TITLE_BIG,
                        fontWeight = FontWeight.Bold,

                        )
                    CVPCard(
                        modifier = Modifier
                            .padding(PaddingDim.SMALL)

                    ) {
                        Row(
                            modifier = Modifier
                                .padding(PaddingDim.SMALL),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .weight(3f)
                                    .fillMaxWidth(),
                                verticalArrangement = Arrangement.SpaceBetween,
                                horizontalAlignment = Alignment.Start
                            ) {
                                CVPText(
                                    text = formatStringResource(stringResource(id = R.string.education)),
                                    maxLines = Int.MAX_VALUE,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier
                                        .padding(PaddingDim.SMALL)
                                )

                            }
                            CVPTooltipIconButton(
                                modifier = Modifier
                                    .weight(3f),
                                icon = CVPIcons.VisibilityIcon,
                                onClick = { viewEducation = true },
                                tooltipMsg = "Visibility",
                                contentDescription = "Visibility"
                            )
                        }

                    }
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CVPText(
                        modifier = Modifier.padding(
                            top = PaddingDim.MEDIUM,
                            bottom = PaddingDim.SMALL
                        ),
                        text = stringResource(id = R.string.honors),
                        fontSize = FontSizes.TITLE_BIG,
                        fontWeight = FontWeight.Bold,

                        )
                    CVPCard(
                        modifier = Modifier
                            .padding(PaddingDim.SMALL)

                    ) {
                        Row(
                            modifier = Modifier
                                .padding(PaddingDim.SMALL),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .weight(3f)
                                    .fillMaxWidth(),
                                verticalArrangement = Arrangement.SpaceBetween,
                                horizontalAlignment = Alignment.Start
                            ) {
                                CVPText(
                                    text = stringResource(id = R.string.coauthor_article),
                                    maxLines = Int.MAX_VALUE,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier
                                        .padding(PaddingDim.SMALL)
                                )

                            }
                            CVPTooltipIconButton(
                                modifier = Modifier
                                    .weight(3f),
                                icon = CVPIcons.VisibilityIcon,
                                onClick = { viewHonors = true },
                                tooltipMsg = "Visibility",
                                contentDescription = "Visibility"
                            )
                        }

                    }
                }
            }
        }
    }
}

