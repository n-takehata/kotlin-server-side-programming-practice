package com.book.manager.infrastructure.database.record

import java.time.LocalDate
import java.time.LocalDateTime

// Book, Rentalレコードをjoinして表示形式に整えるクラス
data class BookWithRentalRecord(
    // from book record
    var id: Long? = null,
    var title: String? = null,
    var author: String? = null,
    var releaseDate: LocalDate? = null,
    // from rental record
    var userId: Long? = null,
    var rentalDatetime: LocalDateTime? = null,
    var returnDeadline: LocalDateTime? = null
)
