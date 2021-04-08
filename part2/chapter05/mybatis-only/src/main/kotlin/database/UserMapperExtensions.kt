/*
 * Auto-generated file. Created by MyBatis Generator
 */
package database

import database.UserDynamicSqlSupport.User
import database.UserDynamicSqlSupport.User.age
import database.UserDynamicSqlSupport.User.id
import database.UserDynamicSqlSupport.User.name
import database.UserDynamicSqlSupport.User.profile
import database.UserRecord
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.util.kotlin.*
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

fun UserMapper.count(completer: CountCompleter) =
    countFrom(this::count, User, completer)

fun UserMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, User, completer)

fun UserMapper.deleteByPrimaryKey(id_: Int) =
    delete {
        where(id, isEqualTo(id_))
    }

fun UserMapper.insert(record: UserRecord) =
    insert(this::insert, record, User) {
        map(id).toProperty("id")
        map(name).toProperty("name")
        map(age).toProperty("age")
        map(profile).toProperty("profile")
    }

fun UserMapper.insertMultiple(records: Collection<UserRecord>) =
    insertMultiple(this::insertMultiple, records, User) {
        map(id).toProperty("id")
        map(name).toProperty("name")
        map(age).toProperty("age")
        map(profile).toProperty("profile")
    }

fun UserMapper.insertMultiple(vararg records: UserRecord) =
    insertMultiple(records.toList())

fun UserMapper.insertSelective(record: UserRecord) =
    insert(this::insert, record, User) {
        map(id).toPropertyWhenPresent("id", record::id)
        map(name).toPropertyWhenPresent("name", record::name)
        map(age).toPropertyWhenPresent("age", record::age)
        map(profile).toPropertyWhenPresent("profile", record::profile)
    }

private val columnList = listOf(id, name, age, profile)

fun UserMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, User, completer)

fun UserMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, User, completer)

fun UserMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, User, completer)

fun UserMapper.selectByPrimaryKey(id_: Int) =
    selectOne {
        where(id, isEqualTo(id_))
    }

fun UserMapper.update(completer: UpdateCompleter) =
    update(this::update, User, completer)

fun KotlinUpdateBuilder.updateAllColumns(record: UserRecord) =
    apply {
        set(id).equalTo(record::id)
        set(name).equalTo(record::name)
        set(age).equalTo(record::age)
        set(profile).equalTo(record::profile)
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(record: UserRecord) =
    apply {
        set(id).equalToWhenPresent(record::id)
        set(name).equalToWhenPresent(record::name)
        set(age).equalToWhenPresent(record::age)
        set(profile).equalToWhenPresent(record::profile)
    }

fun UserMapper.updateByPrimaryKey(record: UserRecord) =
    update {
        set(name).equalTo(record::name)
        set(age).equalTo(record::age)
        set(profile).equalTo(record::profile)
        where(id, isEqualTo(record::id))
    }

fun UserMapper.updateByPrimaryKeySelective(record: UserRecord) =
    update {
        set(name).equalToWhenPresent(record::name)
        set(age).equalToWhenPresent(record::age)
        set(profile).equalToWhenPresent(record::profile)
        where(id, isEqualTo(record::id))
    }