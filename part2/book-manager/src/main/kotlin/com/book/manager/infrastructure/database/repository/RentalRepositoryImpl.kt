package com.book.manager.infrastructure.database.repository

import com.book.manager.domain.model.Rental
import com.book.manager.domain.repository.RentalRepository
import com.book.manager.infrastructure.database.mapper.RentalMapper
import com.book.manager.infrastructure.database.mapper.deleteByPrimaryKey
import com.book.manager.infrastructure.database.mapper.insert
import com.book.manager.infrastructure.database.record.RentalRecord
import org.springframework.stereotype.Repository

@Suppress("SpringJavaInjectionPointsAutowiringInspection")
@Repository
class RentalRepositoryImpl(
    private val rentalMapper: RentalMapper
) : RentalRepository {
    override fun startRental(rental: Rental) {
        rentalMapper.insert(toRecord(rental))
    }

    override fun endRental(bookId: Long) {
        rentalMapper.deleteByPrimaryKey(bookId)
    }

    private fun toRecord(model: Rental): RentalRecord {
        return RentalRecord(model.bookId, model.userId, model.rentalDatetime, model.returnDeadline)
    }
}