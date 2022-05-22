package com.alansilva.data.local.datasource

import io.reactivex.Single
import model.Product

interface ProductCacheDataSource {
    fun getProducts() : Single<List<Product>>
    fun insertData(products: List<Product>)
    fun updateData(products: List<Product>)
}