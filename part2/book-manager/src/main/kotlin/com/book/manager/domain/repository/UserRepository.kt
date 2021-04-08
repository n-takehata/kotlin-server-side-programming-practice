package com.book.manager.domain.repository

import com.book.manager.domain.model.User

interface UserRepository {
    fun find(email: String): User?
    fun find(id: Long): User?
}