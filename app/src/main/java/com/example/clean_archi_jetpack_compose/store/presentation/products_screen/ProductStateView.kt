package com.example.clean_archi_jetpack_compose.store.presentation.products_screen

import com.example.clean_archi_jetpack_compose.store.domain.model.Product

data class ProductStateView(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)