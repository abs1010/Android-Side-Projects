package com.alansilva.lembretedecompras.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.alansilva.lembretedecompras.dao.LembretedeComprasRoomDatabase
import com.alansilva.lembretedecompras.models.Product
import com.alansilva.lembretedecompras.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val productRepository: ProductRepository
    val products: LiveData<List<Product>>

    init {
        val productDAO = LembretedeComprasRoomDatabase.getDatabase(application).productDAO()
        productRepository = ProductRepository(productDAO)
        products = productRepository.products
    }

    fun insert(product: Product) = viewModelScope.launch(Dispatchers.IO) {
        productRepository.insert(product)
    }
}