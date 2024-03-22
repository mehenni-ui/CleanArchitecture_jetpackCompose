package com.example.clean_archi_jetpack_compose.store.domain.repository

import arrow.core.Either
import com.example.clean_archi_jetpack_compose.store.domain.model.NetworkError
import com.example.clean_archi_jetpack_compose.store.domain.model.Product

interface ProductRepository {

    suspend fun getAllProducts() : Either<NetworkError, List<Product>>

}