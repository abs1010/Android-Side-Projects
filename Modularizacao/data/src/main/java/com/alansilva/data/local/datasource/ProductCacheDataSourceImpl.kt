package com.alansilva.data.local.datasource

import com.alansilva.data.local.database.ProductsDao
import com.alansilva.data.local.mapper.ProductCacheMapper
import io.reactivex.Single
import model.Product

class ProductCacheDataSourceImpl(
    private val productDao: ProductsDao
) : ProductCacheDataSource {

    override fun getProducts(): Single<List<Product>> {
        return productDao.getProducts().map {
            ProductCacheMapper.mapProductCacheToProduct(it)
        }
    }

    override fun insertData(products: List<Product>) {
        productDao.insertAll(ProductCacheMapper.mapProductToProductCache(products))
    }

    override fun updateData(products: List<Product>) {
        productDao.updateData(ProductCacheMapper.mapProductToProductCache(products))
    }

}