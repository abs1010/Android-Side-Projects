package com.alansilva.lembretedecompras.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alansilva.lembretedecompras.databinding.ProductItemBinding
import com.alansilva.lembretedecompras.models.Product

class MainListAdapter : RecyclerView.Adapter<MainListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root)

    private var products = emptyList<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(products[position]){
                binding.tvProduct.text = this.name
            }
        }
    }

    internal fun setProducts(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    // Number Of Rows in Section (equivalent)
    override fun getItemCount(): Int {
        return products.size
    }
}