package com.saico.cvportfolio.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.saico.cvportfolio.theme.AppDim
import com.saico.cvportfolio.theme.CornerDim
import com.saico.cvportfolio.theme.PaddingDim

@Composable
fun CVPIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    background: Color,
    contentDescription: String? = null,
    tint: Color = LocalContentColor.current
) {
    Box(
        modifier = modifier
            .size(AppDim.LIST_ICONS_SIZE)
            .clip(RoundedCornerShape(CornerDim.SMALL))
            .background(background),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.padding(PaddingDim.VERY_SMALL),
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = tint
        )
    }
}
