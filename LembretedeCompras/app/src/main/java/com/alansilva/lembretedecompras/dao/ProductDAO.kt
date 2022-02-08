package com.alansilva.lembretedecompras.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alansilva.lembretedecompras.models.Product

@Dao
interface ProductDAO {

    @Query("SELECT * from tabela_produto ORDER BY nome ASC")
    fun getProducts(): LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(product: Product)

    @Query("DELETE FROM tabela_produto")
    suspend fun deleteAll()

}