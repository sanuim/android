package com.example.models
import org.jetbrains.exposed.sql.*
data class Product(val id: Int, val name: String, val description: String, val price: Double)

object Products : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 128)
    val description = varchar("description", 1024)
    val price = double("price")

    override val primaryKey = PrimaryKey(id)
}