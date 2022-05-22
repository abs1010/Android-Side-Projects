package com.alansilva.data.di

import com.alansilva.data.repository.ProductRepositoryImpl
import org.koin.dsl.module
import repository.ProductRepository

val repositoryModule = module {
    factory<ProductRepository> {
        ProductRepositoryImpl(
            productsCacheDataSource = get(),
            productRemoteDataSource = get()
        )
    }
}

val dataModules = listOf(remoteDataSourceModule, repositoryModule, cacheDataModule)