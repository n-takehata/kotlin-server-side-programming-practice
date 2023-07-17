/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.book.manager.infrastructure.database.mapper

import java.sql.JDBCType
import java.time.LocalDate
import org.mybatis.dynamic.sql.SqlTable

object BookDynamicSqlSupport {
    object Book : SqlTable("book") {
        val id = column<Long>("id", JDBCType.BIGINT)

        val title = column<String>("title", JDBCType.VARCHAR)

        val author = column<String>("author", JDBCType.VARCHAR)

        val releaseDate = column<LocalDate>("release_date", JDBCType.DATE)
    }
}