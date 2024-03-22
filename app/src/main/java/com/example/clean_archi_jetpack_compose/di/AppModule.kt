package com.example.clean_archi_jetpack_compose.di

import com.example.clean_archi_jetpack_compose.store.data.remote.ProductAPi
import com.example.clean_archi_jetpack_compose.store.data.repository.ProductRepositoryImpli
import com.example.clean_archi_jetpack_compose.store.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideProductApi(): ProductAPi{
        return Retrofit
            .Builder()
            .baseUrl(" https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ProductAPi::class.java)
    }


}