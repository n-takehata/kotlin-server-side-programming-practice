package com.example.demo

class Executor(private val greeter: Greeter) {
    fun execute() {
        greeter.sayHello("world")
    }
}