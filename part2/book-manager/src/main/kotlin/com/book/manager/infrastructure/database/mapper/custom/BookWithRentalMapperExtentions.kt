package com.book.manager.infrastructure.database.mapper.custom

import com.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.Book
import com.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.Book.author
import com.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.Book.id
import com.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.Book.releaseDate
import com.book.manager.infrastructure.database.mapper.BookDynamicSqlSupport.Book.title
import com.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.Rental
import com.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.Rental.rentalDatetime
import com.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.Rental.returnDeadline
import com.book.manager.infrastructure.database.mapper.RentalDynamicSqlSupport.Rental.userId
import com.book.manager.infrastructure.database.record.custom.BookWithRentalRecord
import org.mybatis.dynamic.sql.SqlBuilder.equalTo
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.SqlBuilder.select
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.from

private val columnList = listOf(
    id,
    title,
    author,
    releaseDate,
    userId,
    rentalDatetime,
    returnDeadline
)

fun BookWithRentalMapper.select(): List<BookWithRentalRecord> {
    val selectStatement = select(columnList).from(Book, "b") {
        leftJoin(Rental, "r") {
            on(Book.id, equalTo(Rental.bookId))
        }
    }
    return selectMany(selectStatement)
}

fun BookWithRentalMapper.selectByPrimaryKey(id_: Long): BookWithRentalRecord? {
    val selectStatement = select(columnList).from(Book, "b") {
        leftJoin(Rental, "r") {
            on(Book.id, equalTo(Rental.bookId))
        }
        where(id, isEqualTo(id_))
    }
    return selectOne(selectStatement)
}
