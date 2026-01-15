package com.lyft.technicalscreen.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.lifecycle.ViewModel

class ContentViewViewModel : ViewModel() {
    val images = mutableListOf(
        Icons.Default.Face,
        Icons.Default.Favorite,
        Icons.Default.Star,
        Icons.Default.ShoppingCart,
        Icons.Default.Home,
        Icons.Default.ThumbUp,
        Icons.Default.Face,
        Icons.Default.Favorite,
        Icons.Default.Star,
        Icons.Default.ShoppingCart,
        Icons.Default.Home,
        Icons.Default.ThumbUp,
    )
    val keys = images.take(6)
    val a = images.shuffle()
    val b = mutableMapOf<Icons, List<Pair<Int, Boolean>>>()
    // create a map, keys are the icons and the values are an array of the pairs of indexes and click status

}

sealed interface UiState {
    data class Match(val index1: Int, val index2: Int)
    data class OneClick(val index: Int)
    data class NoMatch(val index: Int)
    data object Idle
}