package com.example.clean_archi_jetpack_compose.di

import com.example.clean_archi_jetpack_compose.store.data.repository.ProductRepositoryImpli
import com.example.clean_archi_jetpack_compose.store.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Binds
    @Singleton
    abstract fun bindProductApi(impli: ProductRepositoryImpli): ProductRepository
}