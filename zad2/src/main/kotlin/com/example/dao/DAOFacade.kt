package com.example.dao

import com.example.models.*

interface DAOFacade {
    suspend fun allProducts(): List<Product>
    suspend fun product(id: Int): Product?
    suspend fun addNewProduct(name: String, description: String, price: Double): Product?
    suspend fun editProducts(id: Int, name: String,  description: String, price: Double): Boolean
    suspend fun deleteProducts(id: Int): Boolean
}