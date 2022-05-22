package repository

import io.reactivex.Single
import model.Product

interface ProductRepository {
    fun getProducts(forceUpdate: Boolean) : Single<List<Product>>
}