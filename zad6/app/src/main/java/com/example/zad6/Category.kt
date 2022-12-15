package com.example.zad6

import com.google.gson.annotations.SerializedName

data class Category (
    @SerializedName("name")
    var name: String? = null
)