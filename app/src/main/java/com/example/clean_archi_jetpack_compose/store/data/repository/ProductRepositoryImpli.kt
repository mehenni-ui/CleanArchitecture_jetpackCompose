package com.example.clean_archi_jetpack_compose.store.data.repository

import arrow.core.Either
import com.example.clean_archi_jetpack_compose.store.data.mapper.toNetworkError
import com.example.clean_archi_jetpack_compose.store.data.remote.ProductAPi
import com.example.clean_archi_jetpack_compose.store.domain.model.NetworkError
import com.example.clean_archi_jetpack_compose.store.domain.model.Product
import com.example.clean_archi_jetpack_compose.store.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpli @Inject constructor(
    private val productAPi: ProductAPi
): ProductRepository {
    override suspend fun getAllProducts(): Either<NetworkError, List<Product>> {
        return Either.catch {
            productAPi.getALlProducts()
        }.mapLeft {
            it.toNetworkError()
        }
    }
}