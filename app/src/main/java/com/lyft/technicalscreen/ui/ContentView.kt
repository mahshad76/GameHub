package com.lyft.technicalscreen.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

private val ColorBlue = Color.Blue.copy(red = 0.2f, blue = 0.9f, green = 0.3f, alpha = 0.8f)
private val ColorYellow = Color.Yellow.copy(red = 0.9f, blue = 0.2f, green = 0.77f, alpha = 0.9f)
private val ColorGreen = Color.Green.copy(red = 0.02f, blue = 0.16f, green = 0.70f, alpha = 0.8f)

@Composable
fun ContentView(contentViewViewModel: ContentViewViewModel = viewModel()) {
    val images = contentViewViewModel.images
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp),
    ) {
        var i = 0
        items(12) { index ->
            CardButton(images[index], index, { contentViewViewModel.updateOnClick(it) })
        }
    }
}

@Composable
private fun CardButton(image: ImageVector, index: Int, onClick: (Int) -> Unit) {
    Button(
        modifier = Modifier.aspectRatio(1.0f),
        //colors =,
        shape = RoundedCornerShape(CornerSize(10.dp)),
        onClick = {
            onClick(index)
        }
    ) {
        Image(imageVector = image, "", Modifier.fillMaxSize())
    }
}