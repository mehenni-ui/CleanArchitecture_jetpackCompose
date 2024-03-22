package com.example.clean_archi_jetpack_compose.store.data.remote

import com.example.clean_archi_jetpack_compose.store.domain.model.Product
import retrofit2.http.GET

interface ProductAPi {

    @GET("products")
    suspend fun getALlProducts(): List<Product>
}