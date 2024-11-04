package com.saico.cvportfolio.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Download
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage

@Composable
fun CoilImageLoad(
    image: Any?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    networkSaving: Boolean = false,
    contentScale: ContentScale = ContentScale.Fit,
    errorContent: (@Composable () -> Unit)? = null,
    containerColor: Color = MaterialTheme.colorScheme.surfaceVariant,
) {

    var shouldLoad by remember {
        mutableStateOf(false)
    }

    SubcomposeAsyncImage(
        model = if (networkSaving && !shouldLoad) null
        else image,
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = Modifier
            .sizeIn(minWidth = 52.dp, minHeight = 52.dp)
                then modifier,
        loading = {
            CompositionLocalProvider(
                LocalContentColor provides contentColorFor(containerColor)
            ) {

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(52.dp),
                        strokeCap = StrokeCap.Round
                    )

                    if (networkSaving) {
                        IconButton(
                            onClick = { shouldLoad = false }
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Clear,
                                contentDescription = "cancel icon"
                            )
                        }
                    }
                }
            }
        },
        error = {
            if (networkSaving && !shouldLoad) {
                CompositionLocalProvider(
                    LocalContentColor provides contentColorFor(containerColor)
                ) {

                    IconButton(
                        onClick = { shouldLoad = true },
                        modifier = Modifier.align(Alignment.Center)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Download,
                            contentDescription = "download icon"
                        )
                    }
                }
            } else {
                errorContent?.let { it() }
            }
        },
    )
}