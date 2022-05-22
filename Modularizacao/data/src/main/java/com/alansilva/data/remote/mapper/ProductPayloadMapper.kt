package com.alansilva.data.remote.mapper

import com.alansilva.data.remote.model.ProductPayload
import model.Product

object ProductPayloadMapper {

    fun map(products: List<ProductPayload>) = products.map { map(it) }

    private fun map(productPayload: ProductPayload) = Product(
        name = productPayload.name,
        imageURL = productPayload.imageURL,
        description = productPayload.description
    )
}