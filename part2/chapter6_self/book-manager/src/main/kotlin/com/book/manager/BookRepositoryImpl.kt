package com.book.manager

import org.springframework.stereotype.Repository
import com.book.manager.infrastructure.database.record.BookWithRentalRecord

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class BookRepositoryImpl (
    private val bookWithRentalMapper: BookWithRentalMapper
): BookRepository {
    override fun findAllWithRental(): List<BookWithRental> {
        return bookWithRentalMapper.select().map { toModel(it)}
    }

    fun toModel(record: BookWithRentalRecord): BookWithRental {
        val book = Book(
            id = record.id!!,
            title = record.title!!,
            author = record.author!!,
            releaseDate = record.releaseDate!!
        )
        val rental = record.userId?.let {
            Rental(
                bookId = record.id!!,
                userId = record.userId!!,
                rentalDatetime = record.rentalDatetime!!,
                returnDeadline = record.returnDeadline!!
            )
        }
        return BookWithRental(book, rental)
    }
}