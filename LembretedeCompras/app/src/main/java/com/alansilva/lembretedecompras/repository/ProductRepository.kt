package com.alansilva.lembretedecompras.repository

import androidx.lifecycle.LiveData
import com.alansilva.lembretedecompras.dao.ProductDAO
import com.alansilva.lembretedecompras.models.Product

class ProductRepository(private val productDAO: ProductDAO) {
    val products: LiveData<List<Product>> = productDAO.getProducts()
    suspend fun insert(product: Product) {
        productDAO.insert(product)
    }
}