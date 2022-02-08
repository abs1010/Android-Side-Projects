package com.alansilva.lembretedecompras.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alansilva.lembretedecompras.R
import com.alansilva.lembretedecompras.databinding.ActivityMainBinding
import com.alansilva.lembretedecompras.models.Product
import com.alansilva.lembretedecompras.ui.newproduct.NewProductActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel

    private lateinit var adapter: MainListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setUpRecyclerView()
        initViewModel()
        initObserver()
        initListeners()

    }

    private fun initListeners() {
        binding.fabNewProduct.setOnClickListener {
            val nextScreen = Intent(this, NewProductActivity::class.java)
            newProductRequest.launch(nextScreen)
        }
    }

    private val newProductRequest = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

            if (it.resultCode == RESULT_OK) {
                it.data?.getStringExtra(NewProductActivity.EXTRA_REPLY)?.let {
                    val product = Product(it)
                    mainViewModel.insert(product)
                }
            }

        }

    private fun initViewModel() {
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private fun initObserver() {

        mainViewModel.products.observe(this, { produtos ->
            produtos?.let { adapter.setProducts(it) }
        })
        
    }

    private fun setUpRecyclerView() {
        adapter = MainListAdapter()
        binding.rvProducts.adapter = adapter
        binding.rvProducts.layoutManager = LinearLayoutManager(this)
    }
}