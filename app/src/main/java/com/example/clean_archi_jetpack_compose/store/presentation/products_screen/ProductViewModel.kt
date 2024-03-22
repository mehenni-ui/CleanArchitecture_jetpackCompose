package com.example.clean_archi_jetpack_compose.store.presentation.products_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_archi_jetpack_compose.store.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
): ViewModel() {

    private val _state = MutableStateFlow(ProductStateView())
    val state = _state.asStateFlow()

    init {
        getALlProducts()
    }

    private fun getALlProducts(){
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }

            productRepository.getAllProducts()
                .onRight {productList->
                    _state.update {
                        it.copy(
                            products = productList,
                            isLoading = false
                        )
                    }
                }
                .onLeft {networkError->
                    _state.update {
                        it.copy(error = networkError.error.message, isLoading = false)
                    }
                }
        }
    }

}