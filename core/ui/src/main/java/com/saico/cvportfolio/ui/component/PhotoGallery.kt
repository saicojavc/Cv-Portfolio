package com.saico.cvportfolio.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun PhotoGallery(photos: List<Int>, onPhotoClick: (Int) -> Unit) {
    LazyVerticalGrid(
        modifier = Modifier.heightIn(max = 2000.dp),
        columns = GridCells.Fixed(3),
    ) {

        items(photos) { photoId ->
            Image(
                painter = rememberImagePainter(photoId),
                contentDescription = null,
                modifier = Modifier
                    .padding(4.dp)
                    .clickable { onPhotoClick(photoId) }
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
        }
    }
}