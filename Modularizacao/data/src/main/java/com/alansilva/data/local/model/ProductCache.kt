package com.alansilva.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductCache(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var name: String = "",
    var imageURL: String = "",
    var description: String = ""
)