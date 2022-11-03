package com.example.plugins

import com.example.dao.dao
import com.example.models.Product
import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        gson()
    }
}
