package com.example.plugins

import com.example.dao.dao
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.util.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("product") {
            call.respond(dao.allProducts())
        }
        post("product") {
            val formParameters = call.receiveParameters()
            val name = formParameters.getOrFail("name")
            val description = formParameters.getOrFail("description")
            val price = formParameters.getOrFail("price").toDouble()
            val product = dao.addNewProduct(name, description, price)
            call.respondRedirect("/articles/${product?.id}")
        }
        get("product/{id}") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            val product = dao.product(id)
            if(product != null) {
                call.respond(product)
            }
            else{
                call.respondText(text = "Does not exist", status = HttpStatusCode.NotFound)
            }
        }
        get("product/{id}/edit") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            call.respond(FreeMarkerContent("edit.ftl", mapOf("article" to dao.product(id))))
        }
        post("product/{id}") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            val formParameters = call.receiveParameters()
            when (formParameters.getOrFail("_action")) {
                "update" -> {
                    val name = formParameters.getOrFail("name =")
                    val description = formParameters.getOrFail("description")
                    val price = formParameters.getOrFail("price").toDouble()
                    dao.editProducts(id, name, description, price)
                    call.respondRedirect("/articles/$id")
                }
                "delete" -> {
                    dao.deleteProducts(id)
                    call.respondRedirect("/articles")
                }
            }
        }
    }
}
