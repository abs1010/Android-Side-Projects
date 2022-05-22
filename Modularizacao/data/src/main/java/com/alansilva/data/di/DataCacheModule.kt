package com.alansilva.data.di

import com.alansilva.data.local.database.ProductDataBase
import com.alansilva.data.local.datasource.ProductCacheDataSource
import com.alansilva.data.local.datasource.ProductCacheDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val cacheDataModule = module {
    single { ProductDataBase.createDataBase(androidContext()) }
    factory<ProductCacheDataSource> { ProductCacheDataSourceImpl(productDao = get()) }
}