package com.saico.cvportfolio.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.saico.cvportfolio.theme.AppDim
import com.saico.cvportfolio.theme.BorderDim
import com.saico.cvportfolio.theme.CVPColors
import com.saico.cvportfolio.theme.DarkColors
import com.saico.cvportfolio.theme.FontSizes
import com.saico.cvportfolio.theme.LightColors
import com.saico.cvportfolio.theme.PaddingDim
import com.saico.cvportfolio.ui.CVPText
import com.saico.cvportfolio.ui.CoilImageLoad
import com.saico.cvportfolio.ui.R
import kotlinx.coroutines.delay

@Composable
fun MainAboutMeScreen(
    modifier: Modifier,
) {
    Content()
}

@Composable
fun Content() {

    val items = listOf(R.drawable.dev, R.drawable.dev1, R.drawable.dev3)
    val itemsText = listOf(
        R.string.mesage1,
        R.string.mesage2,
        R.string.mesage3
    )
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { items.size }
    )
    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            pagerState.animateScrollToPage((pagerState.currentPage + 1) % items.size)
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (topBox, profile, description, bottomCard, proyects) = createRefs()

            Box(
                modifier = Modifier
                    .height(AppDim.LAYOUT_DIMEN)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = BorderDim.EXTRA_HUGE,
                            bottomEnd = BorderDim.HUGE
                        )
                    )
                    .constrainAs(topBox) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .background(color = Color(android.graphics.Color.parseColor("#FF9D1ED4")))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = PaddingDim.HUGE,
                            end = PaddingDim.LARGE,
                            start = PaddingDim.LARGE
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        CVPText(
                            text = stringResource(id = R.string.my_name),
                            color = LightColors.SurfaceContainerHigh,
                            fontWeight = FontWeight.Bold,
                            fontSize = FontSizes.TITLE
                        )
                        CVPText(
                            text = stringResource(id = R.string.myname),
                            color = LightColors.SurfaceContainerHigh,
                            fontWeight = FontWeight.Bold,
                            fontSize = FontSizes.TITLE
                        )
                        CVPText(
                            modifier = Modifier.padding(top = PaddingDim.MEDIUM),
                            text = stringResource(id = R.string.android_developer),
                            color = LightColors.SurfaceContainerHigh,
                            fontWeight = FontWeight.Bold,
                            fontSize = FontSizes.TITLE_BIG
                        )
                    }

                    CoilImageLoad(
                        modifier = Modifier.clip(shape = CircleShape),
                        image = "https://media.licdn.com/dms/image/v2/D5603AQH38XxLRu4zNg/profile-displayphoto-shrink_200_200/profile-displayphoto-shrink_200_200/0/1701630050849?e=2147483647&v=beta&t=peXQFsaBLTIs5sTpgfcBcZY4I2bHnFl4ojk0pDeqXn4",
                        contentDescription = ""
                    )

                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = PaddingDim.EXTRA_LARGE,
                        start = PaddingDim.HUGE,
                        end = PaddingDim.HUGE
                    )
                    .shadow(3.dp, shape = RoundedCornerShape(PaddingDim.EXTRA_LARGE))
                    .background(color = /*if (isSystemInDarkTheme()) DarkColors.OnSecondary else*/ CVPColors().white)
                    .constrainAs(profile) {
                        top.linkTo(topBox.bottom)
                        bottom.linkTo(topBox.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Column(
                    modifier = Modifier
                        .padding(PaddingDim.MEDIUM)
                        .height(90.dp)
                        .width(90.dp)
                        .background(
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            shape = RoundedCornerShape(PaddingDim.VERY_LARGE)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.kotlin),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(PaddingDim.VERY_LARGE))
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(PaddingDim.MEDIUM)
                        .height(90.dp)
                        .width(90.dp)
                        .background(
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            shape = RoundedCornerShape(PaddingDim.VERY_LARGE)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.compose),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(PaddingDim.VERY_LARGE))
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(PaddingDim.MEDIUM)
                        .height(90.dp)
                        .width(90.dp)
                        .background(
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            shape = RoundedCornerShape(PaddingDim.VERY_LARGE)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.androidlogo),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(PaddingDim.VERY_LARGE))
                    )
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = PaddingDim.GIGANT,
                        start = PaddingDim.SMALL,
                        end = PaddingDim.SMALL
                    )
                    .shadow(3.dp, shape = RoundedCornerShape(PaddingDim.EXTRA_LARGE))
                    .background(color = /*if (isSystemInDarkTheme()) DarkColors.OnSecondary else */CVPColors().white)
                    .constrainAs(description) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                CVPText(
                    modifier = Modifier
                        .padding(PaddingDim.LARGE),
                    text = stringResource(id = R.string.mesage4),
                    maxLines = 6,
                    fontWeight = FontWeight.Bold
                )

            }

            HorizontalPager(
                state = pagerState,
                beyondViewportPageCount = items.size,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = PaddingDim.ROW_HEIGHT)
                    .constrainAs(bottomCard) {
                        top.linkTo(description.bottom)
                        bottom.linkTo(description.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) { pages ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = PaddingDim.SMALL,
                            end = PaddingDim.SMALL
                        )
                        .shadow(3.dp, shape = RoundedCornerShape(PaddingDim.EXTRA_LARGE))
                        .background(color = /*if (isSystemInDarkTheme()) DarkColors.OnSecondary else */CVPColors().white)
                ) {
                    CVPText(
                        modifier = Modifier
                            .weight(2f)
                            .padding(PaddingDim.SMALL),
                        text = stringResource(id = itemsText[pages]),
                        maxLines = 5,
                        fontWeight = FontWeight.Bold
                    )

                    Column(
                        modifier = Modifier
                            .padding(PaddingDim.MEDIUM)
                            .weight(2f)
                            .background(
                                color = MaterialTheme.colorScheme.surfaceVariant,
                                shape = RoundedCornerShape(PaddingDim.VERY_LARGE)
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(items[pages]),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(150.dp)
                                .width(200.dp)
                                .clip(shape = RoundedCornerShape(PaddingDim.VERY_LARGE))
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .padding(
                        bottom = 80.dp
                    )
                    .constrainAs(proyects) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(id = R.string.dashboard),
                    fontWeight = FontWeight.Bold
                )

                LazyRow(

                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    item {
                        Image(
                            painter = painterResource(id = R.drawable.ticket_icon),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(PaddingDim.SMALL)
                                .size(100.dp)
                                .background(
                                    color = DarkColors.OnSecondary,
                                    shape = RoundedCornerShape(PaddingDim.VERY_LARGE)
                                )
//                            .clip(shape = RoundedCornerShape(PaddingDim.VERY_LARGE))
                        )
                    }

                    item {
                        Image(
                            painter = painterResource(id = R.drawable.ic_crm_icon_launcher_foreground),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(PaddingDim.SMALL)
                                .size(100.dp)
                                .background(
                                    color = DarkColors.OnSecondary,
                                    shape = RoundedCornerShape(PaddingDim.VERY_LARGE)
                                )
//                            .clip(shape = RoundedCornerShape(PaddingDim.VERY_LARGE))
                        )
                    }
                    item {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_porter),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(PaddingDim.SMALL)
                                .size(100.dp)
                                .background(
                                    color = DarkColors.OnSecondary,
                                    shape = RoundedCornerShape(PaddingDim.VERY_LARGE)
                                )
//                            .clip(shape = RoundedCornerShape(PaddingDim.VERY_LARGE))
                        )
                    }
                }
            }


        }
    }


}

