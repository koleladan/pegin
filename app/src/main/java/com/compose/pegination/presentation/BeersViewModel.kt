package com.compose.pegination.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.compose.pegination.data.local.BeersEntity
import com.compose.pegination.data.local.toBeers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class BeersViewModel @Inject constructor(
    pager: Pager<Int, BeersEntity>
): ViewModel() {
    val beersPagingFlow = pager
        .flow
        .map { pagingData ->
            pagingData.map { it.toBeers() }
        }
        .cachedIn(viewModelScope)
}