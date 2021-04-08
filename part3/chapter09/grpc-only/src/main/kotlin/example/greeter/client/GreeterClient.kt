package example.greeter.client

import example.greeter.GreeterGrpcKt
import example.greeter.HelloRequest
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

private const val HOST = "localhost"
private const val PORT = 50051

fun main() = runBlocking {
    val channel = ManagedChannelBuilder.forAddress(HOST, PORT)
        .usePlaintext()
        .build()

    try {
        val stub = GreeterGrpcKt.GreeterCoroutineStub(channel)

        val name = "Kotlin"
        val request = HelloRequest.newBuilder().setName(name).build()
        val response = async { stub.hello(request) }

        println("Response Text: ${response.await().text}")
    } finally {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    }
}