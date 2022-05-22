package com.alansilva.data.remote.datasource

import io.reactivex.Single
import model.Product

interface ProductRemoteDataSource {
    fun getProducts() : Single<List<Product>>
}