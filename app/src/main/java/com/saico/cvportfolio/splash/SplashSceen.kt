package com.saico.cvportfolio.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.saico.cvportfolio.ui.R
import com.saico.cvportfolio.theme.AppDim
import com.saico.cvportfolio.theme.PaddingDim
import com.saico.cvportfolio.ui.CVPTextTitle

@Composable
fun SplashScreen() {
    ConstraintLayout(
        Modifier
            .fillMaxSize()
    ) {
        val (others, bottomImg, topImg) = createRefs()
        Image(
            painterResource(id = R.drawable.men),
            contentDescription = "logo",
            modifier = Modifier
                .size(AppDim.SIGNATURE_PAD_HEIGHT)
                .padding(top = PaddingDim.GIGANT)
                .constrainAs(topImg) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.bottom_background),
            contentDescription = "img",
            modifier = Modifier
                .width(800.dp)
                .constrainAs(bottomImg) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            contentScale = ContentScale.Crop

        )

        CVPTextTitle(
            modifier = Modifier
                .padding(PaddingDim.EXTRA_HUGE)
                .constrainAs(others) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            text = stringResource(id = R.string.app_name)
        )

    }
}