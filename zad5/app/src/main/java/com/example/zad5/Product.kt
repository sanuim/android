package com.example.zad5

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("description")
    var description: String? = null,

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("title") //name
    var title: String? = null,

    @SerializedName("price")
    var price: String? = null,

    @SerializedName("image")
    var image: String? = null,

    @SerializedName("category")
    var category: String? = null
)