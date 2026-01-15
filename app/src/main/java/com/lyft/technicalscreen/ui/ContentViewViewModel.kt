package com.lyft.technicalscreen.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

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
    val state = mutableMapOf<ImageVector, MutableList<Pair<Int, Boolean>>>()

    init {
        for (k in keys) {
            val indexes = findIndex(k)
            state[k] = mutableListOf(
                Pair(indexes.first, false), Pair(
                    indexes.second,
                    false
                )
            )

        }
    }

    private fun findIndex(k: ImageVector): Pair<Int, Int> {
        return Pair(1, 2)
    }

    private val _uiStateFlow: MutableStateFlow<UiState> = MutableStateFlow(UiState.Idle)
    val uiStateFlow = _uiStateFlow.asStateFlow()

    fun updateOnClick(index: Int) {
        when(state[images[index]]){
            
        }

    }
    // create a map, keys are the icons and the values are an array of the pairs of indexes and click status

}

sealed interface UiState {
    data class Match(val index1: Int, val index2: Int) : UiState
    data class OneClick(val index: Int) : UiState
    data class NoMatch(val index: Int) : UiState
    data object Idle : UiState
}