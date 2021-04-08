package com.book.manager.infrastructure.database.mapper.custom

import com.book.manager.infrastructure.database.record.custom.BookWithRentalRecord
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter

@Mapper
interface BookWithRentalMapper {
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        id = "BookWithRentalRecordResult", value = [
            Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            Result(column = "author", property = "author", jdbcType = JdbcType.VARCHAR),
            Result(column = "release_date", property = "releaseDate", jdbcType = JdbcType.DATE),
            Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            Result(column = "rental_datetime", property = "rentalDatetime", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "return_deadline", property = "returnDeadline", jdbcType = JdbcType.TIMESTAMP)
        ]
    )
    fun selectMany(selectStatement: SelectStatementProvider): List<BookWithRentalRecord>

    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @ResultMap("BookWithRentalRecordResult")
    fun selectOne(selectStatement: SelectStatementProvider): BookWithRentalRecord?
}
