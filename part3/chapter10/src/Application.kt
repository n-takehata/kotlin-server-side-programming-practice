package com.example

import com.example.example.route.bookRoute
import com.example.example.route.greetingRoute
import com.example.example.route.userRoute
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.authenticate
import io.ktor.auth.authentication
import io.ktor.auth.basic
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import io.ktor.locations.Locations
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(Locations)

    install(ContentNegotiation) {
        jackson {
            // シリアライズ、デシリアライズ処理のカスタマイズを記述
        }
    }

    install(Authentication) {
        basic {
            validate { credentials ->
                if (credentials.name == "user" && credentials.password == "password") {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
    }

    routing {
        get("/") {
            call.respondText("Hello Ktor!")
        }

        get("/hello/{name}") {
            val name = call.parameters["name"]
            call.respondText("Hello $name!")
        }

        get("/hello") {
            val name = call.parameters["name"]
            call.respondText("Hello $name!")
        }

        greetingRoute()
        userRoute()
        bookRoute()
        authenticate {
            get("/authenticated") {
                val user = call.authentication.principal<UserIdPrincipal>()
                call.respondText("authenticated id=${user?.name}")
            }
        }
    }
}

