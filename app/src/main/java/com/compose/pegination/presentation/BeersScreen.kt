package com.compose.pegination.presentation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.compose.pegination.domain.model.Beers

@Composable
fun BeersScreen(
    beers: LazyPagingItems<Beers>
){
    val context = LocalContext.current
    LaunchedEffect(key1 = beers.loadState){
        if (beers.loadState.refresh is LoadState.Error){
            Toast.makeText(context, "Error:" + (beers.loadState.refresh as LoadState.Error).error.message, Toast.LENGTH_LONG).show()
        }
    }

}