package com.book.manager

interface BookRepository {
    fun findAllWithRental(): List<BookWithRental>
}