package com.example.grpc.springboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GrpcWithSpringbootApplication

fun main(args: Array<String>) {
    runApplication<GrpcWithSpringbootApplication>(*args)
}
