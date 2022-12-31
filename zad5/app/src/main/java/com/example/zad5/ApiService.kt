package com.example.zad5

import retrofit2.Call
import retrofit2.http.*

interface APIService {
    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("products")
    fun getProducts(
    ): Call<List<Product>>

}