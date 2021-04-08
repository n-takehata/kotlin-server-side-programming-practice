package com.example.grpc.springboot.client

import example.greeter.GreeterGrpcKt
import example.greeter.HelloRequest
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

private const val HOST = "localhost"
private const val PORT = 6565

@RestController
class GreeterClientController {
    @GetMapping("/greeter/hello/{name}")
    fun hello(@PathVariable name: String): String = runBlocking {
        val channel = ManagedChannelBuilder.forAddress(HOST, PORT)
            .usePlaintext()
            .build()

        val request = HelloRequest.newBuilder().setName(name).build()
        val stub = GreeterGrpcKt.GreeterCoroutineStub(channel)

        val response = async { stub.hello(request) }
        response.await().text
    }
}
