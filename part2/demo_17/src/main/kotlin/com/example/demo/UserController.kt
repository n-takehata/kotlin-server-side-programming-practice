package com.example.demo

import com.example.demo.database.UserMapper
import com.example.demo.database.UserRecord
import com.example.demo.database.selectByPrimaryKey
import database.*
import org.springframework.web.bind.annotation.*

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("user")
class UserController (
    val userMapper: UserMapper
) {
    @GetMapping("/select/{id}")
    fun select(@PathVariable("id") id: Int): UserRecord? {
        return userMapper.selectByPrimaryKey(id)
    }
}