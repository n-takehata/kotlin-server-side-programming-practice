package com.example.example.route

import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.route

fun Routing.greetingRoute() {
    get("/") {
        call.respondText("Hello Ktor!")
    }

    route("/greeting") {
        get("/hello") {
            // ・・・
        }

        get("/goodmorning") {
            // ・・・
        }
    }
}