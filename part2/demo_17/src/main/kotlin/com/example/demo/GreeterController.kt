package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("greeter")
class GreeterController (
    private val greeter: Greeter
) {

    @GetMapping("/hello")
    fun hello(@RequestParam("name") name: String): HelloResponse {
        return HelloResponse("Hello, ${name}!")
    }

    @GetMapping("/hello/{name}")
    fun helloPath(@PathVariable("name") name: String): HelloResponse {
        return HelloResponse("Hello, $name!")
    }

    @PostMapping("/hello")
    fun helloPost(@RequestBody request: HelloRequest): HelloResponse {
        return HelloResponse("Hello, ${request.name}!")
    }

    @GetMapping("/hello/byservice/{name}")
    fun helloByService(@PathVariable("name") name: String): HelloResponse {
        val message = greeter.sayHello(name)
        return HelloResponse(message)
    }
}