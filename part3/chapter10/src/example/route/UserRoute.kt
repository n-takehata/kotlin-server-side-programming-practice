package com.example.example.route

import io.ktor.application.call
import io.ktor.auth.Principal
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.authentication
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.Routing
import io.ktor.routing.get

//@Location("/user/{id}")
//data class GetUserLocation(val id: Long)

@Location("/user")
class UserLocation {
    @Location("/{id}")
    data class GetLocation(val id: Long)

    @Location("/detail/{id}")
    data class GetDetailLocation(val id: Long)

    @Location("/authenticated")
    data class AuthenticatedLocation(val id: Long)
}

fun Routing.userRoute() {
//    get<GetUserLocation> { param ->
//        val id = param.id
//        call.respondText("id=$id")
//    }

    get<UserLocation.GetLocation> { param ->
        val id = param.id
        call.respondText("get id=$id")
    }

    get<UserLocation.GetDetailLocation> { param ->
        val id = param.id
        call.respondText("getDetail id=$id")
    }
}

fun Route.authenticatedUserRoute() {
    get("/authenticated") {
        val user = call.authentication.principal<UserIdPrincipal>()
        call.respondText("authenticated id=${user?.name}")
    }
}

data class MyUserPrincipal(val id: Long, val name: String, val profile: String) : Principal