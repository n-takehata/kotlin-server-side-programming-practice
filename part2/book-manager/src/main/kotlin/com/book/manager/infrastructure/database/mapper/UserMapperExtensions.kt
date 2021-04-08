/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.book.manager.infrastructure.database.mapper

import com.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.User
import com.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.User.email
import com.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.User.id
import com.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.User.name
import com.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.User.password
import com.book.manager.infrastructure.database.mapper.UserDynamicSqlSupport.User.roleType
import com.book.manager.infrastructure.database.record.UserRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun UserMapper.count(completer: CountCompleter) =
    countFrom(this::count, User, completer)

fun UserMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, User, completer)

fun UserMapper.deleteByPrimaryKey(id_: Long) =
    delete {
        where(id, isEqualTo(id_))
    }

fun UserMapper.insert(record: UserRecord) =
    insert(this::insert, record, User) {
        map(id).toProperty("id")
        map(email).toProperty("email")
        map(password).toProperty("password")
        map(name).toProperty("name")
        map(roleType).toProperty("roleType")
    }

fun UserMapper.insertMultiple(records: Collection<UserRecord>) =
    insertMultiple(this::insertMultiple, records, User) {
        map(id).toProperty("id")
        map(email).toProperty("email")
        map(password).toProperty("password")
        map(name).toProperty("name")
        map(roleType).toProperty("roleType")
    }

fun UserMapper.insertMultiple(vararg records: UserRecord) =
    insertMultiple(records.toList())

fun UserMapper.insertSelective(record: UserRecord) =
    insert(this::insert, record, User) {
        map(id).toPropertyWhenPresent("id", record::id)
        map(email).toPropertyWhenPresent("email", record::email)
        map(password).toPropertyWhenPresent("password", record::password)
        map(name).toPropertyWhenPresent("name", record::name)
        map(roleType).toPropertyWhenPresent("roleType", record::roleType)
    }

private val columnList = listOf(id, email, password, name, roleType)

fun UserMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, User, completer)

fun UserMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, User, completer)

fun UserMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, User, completer)

fun UserMapper.selectByPrimaryKey(id_: Long) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun UserMapper.update(completer: UpdateCompleter) =
    update(this::update, User, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: UserRecord) =
    apply {
        set(id).equalTo(record::id)
        set(email).equalTo(record::email)
        set(password).equalTo(record::password)
        set(name).equalTo(record::name)
        set(roleType).equalTo(record::roleType)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: UserRecord) =
    apply {
        set(id).equalToWhenPresent(record::id)
        set(email).equalToWhenPresent(record::email)
        set(password).equalToWhenPresent(record::password)
        set(name).equalToWhenPresent(record::name)
        set(roleType).equalToWhenPresent(record::roleType)
    }

fun UserMapper.updateByPrimaryKey(record: UserRecord) =
    update {
        set(email).equalTo(record::email)
        set(password).equalTo(record::password)
        set(name).equalTo(record::name)
        set(roleType).equalTo(record::roleType)
        where(id, isEqualTo(record::id))
    }

fun UserMapper.updateByPrimaryKeySelective(record: UserRecord) =
    update {
        set(email).equalToWhenPresent(record::email)
        set(password).equalToWhenPresent(record::password)
        set(name).equalToWhenPresent(record::name)
        set(roleType).equalToWhenPresent(record::roleType)
        where(id, isEqualTo(record::id))
    }