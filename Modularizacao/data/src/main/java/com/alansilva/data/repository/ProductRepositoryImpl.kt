package com.alansilva.data.repository

import com.alansilva.data.local.datasource.ProductCacheDataSource
import com.alansilva.data.remote.datasource.ProductRemoteDataSource
import io.reactivex.Single
import model.Product
import repository.ProductRepository

class ProductRepositoryImpl(
    private val productsCacheDataSource: ProductCacheDataSource,
    private val productRemoteDataSource: ProductRemoteDataSource
) : ProductRepository {

    override fun getProducts(forceUpdate: Boolean): Single<List<Product>> {

        return if (forceUpdate) {
            getProductsRemote(forceUpdate)
        } else {
            productsCacheDataSource.getProducts()
                .flatMap { listProducts ->
                    when {
                        listProducts.isEmpty() -> getProductsRemote(false)
                        else -> Single.just(listProducts)
                    }
                }
        }
    }

    private fun getProductsRemote(isUpdate: Boolean): Single<List<Product>> {

        return productRemoteDataSource.getProducts()
            .flatMap { products ->
                if (isUpdate)
                    productsCacheDataSource.updateData(products)
                else
                    productsCacheDataSource.insertData(products)
                Single.just(products)
            }
    }

}