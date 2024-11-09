package com.saico.cvportfolio.home.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.saico.cvportfolio.theme.AppDim
import com.saico.cvportfolio.theme.PaddingDim
import com.saico.cvportfolio.ui.R
import com.saico.cvportfolio.ui.component.CVPText

@Composable
fun CurriculumTopBar() {
    ConstraintLayout(
        modifier = Modifier
            .height(AppDim.ROW_DATA_TIME_SIZE)
            .background(color = Color(android.graphics.Color.parseColor("#FF9D1ED4")))
    ) {
        val (arco, topImg, title) = createRefs()

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(arco) {
                    bottom.linkTo(parent.bottom)
                }
                .height(100.dp)
        ) {
            val width = size.width
            val height = size.height

            drawArc(
                color = Color.White,
                startAngle = 180f,
                sweepAngle = 180f,
                useCenter = true,
                topLeft = Offset(0f, height / 2),
                size = Size(width, height)
            )
        }

        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data("https://media.licdn.com/dms/image/v2/D5603AQH38XxLRu4zNg/profile-displayphoto-shrink_200_200/profile-displayphoto-shrink_200_200/0/1701630050849?e=2147483647&v=beta&t=peXQFsaBLTIs5sTpgfcBcZY4I2bHnFl4ojk0pDeqXn4")
                .crossfade(true)
                .build(),
            contentDescription = "",
            modifier = Modifier
                .size(AppDim.IMAGES_WIDTH)
                .clip(CircleShape)
                .fillMaxWidth()
                .constrainAs(topImg) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, margin = PaddingDim.HUGE)
                }
        )
        CVPText(
            text = stringResource(id = R.string.myname),
            style = TextStyle(Color.Black, fontSize = 30.sp),
            modifier = Modifier
                .constrainAs(title) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}