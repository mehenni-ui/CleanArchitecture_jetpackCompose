package com.example.clean_archi_jetpack_compose.store.presentation.products_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.clean_archi_jetpack_compose.store.domain.model.Product
import com.example.clean_archi_jetpack_compose.store.presentation.components.ProductCard
import com.example.clean_archi_jetpack_compose.store.presentation.util.LoadingDialog
import com.example.clean_archi_jetpack_compose.store.presentation.util.MyTopAppBar
import kotlinx.coroutines.processNextEventInCurrentThread


@Composable
internal fun ProductScreen(
    viewModel: ProductViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsStateWithLifecycle()
    ProductContent(stateView = state)
}


@Composable
fun ProductContent(
    stateView: ProductStateView
){
    LoadingDialog(isLoading = stateView.isLoading)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopAppBar(title = "Products")
        }

    ) {paddingValues ->
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(top = paddingValues.calculateTopPadding()),
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalItemSpacing = 5.dp) {

            items(stateView.products){item:Product ->
                ProductCard(product = item)
            }
        }
    }
}