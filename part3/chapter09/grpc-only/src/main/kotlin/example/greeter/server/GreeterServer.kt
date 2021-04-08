package example.greeter.server

import io.grpc.ServerBuilder

private const val PORT = 50051

fun main() {
    val server = ServerBuilder
        .forPort(PORT)
        .addService(GreeterService())
        .build()

    server.start()
    println("Started. port:$PORT")

    server.awaitTermination()
}
