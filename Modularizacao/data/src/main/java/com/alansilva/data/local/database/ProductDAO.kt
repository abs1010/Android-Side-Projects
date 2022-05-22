package com.alansilva.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.alansilva.data.local.model.ProductCache
import io.reactivex.Single

@Dao
interface ProductsDao {

    @Query("SELECT * FROM PRODUCTS")
    fun getProducts() : Single<List<ProductCache>>

    @Transaction
    fun updateData(products: List<ProductCache>) {
        deleteAll()
        insertAll(products)
    }

    @Query("DELETE FROM products")
    fun deleteAll()

    @Insert
    fun insertAll(products: List<ProductCache>)
}