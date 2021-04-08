package com.book.manager.domain.repository

import com.book.manager.domain.model.Rental

interface RentalRepository {
    fun startRental(rental: Rental)
    fun endRental(bookId: Long)
}