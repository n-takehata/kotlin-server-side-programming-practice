package com.example.example.route

import io.ktor.application.call
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.post
import io.ktor.routing.route

fun Routing.bookRoute() {
    route("/book") {
        @Location("/detail/{bookId}")
        data class BookLocation(val bookId: Long)
        get<BookLocation> { request ->
            val response = BookResponse(request.bookId, "Kotlin入門", "Kotlin太郎")
            call.respond(response)
        }

        post("/register") {
            val request = call.receive<RegisterRequest>()
            call.respondText("registered. id=${request.id} title=${request.title} author=${request.author}")
        }
    }
}

data class BookResponse(
    val id: Long,
    val title: String,
    val author: String
)

data class RegisterRequest(
    val id: Long,
    val title: String,
    val author: String
)
