package com.book.manager

import org.springframework.stereotype.Service

@Service
class BookService (
    private val bookRepository: BookRepository
) {
    fun getList(): List<BookWithRental> {
        return bookRepository.findAllWithRental()
    }
}