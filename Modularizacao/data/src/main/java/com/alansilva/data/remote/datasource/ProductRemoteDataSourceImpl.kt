package com.alansilva.data.remote.datasource

import com.alansilva.data.remote.api.ProductAPI
import com.alansilva.data.remote.mapper.ProductPayloadMapper
import io.reactivex.Single
import model.Product

class ProductRemoteDataSourceImpl(private val productAPI: ProductAPI) : ProductRemoteDataSource {
    override fun getProducts(): Single<List<Product>> {
        return productAPI.getProducts().map { ProductPayloadMapper.map(it) }
    }
}