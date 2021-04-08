import database.UserDynamicSqlSupport
import database.UserMapper
import database.UserRecord
import database.count
import database.delete
import database.deleteByPrimaryKey
import database.insert
import database.insertMultiple
import database.select
import database.selectByPrimaryKey
import database.update
import database.updateByPrimaryKeySelective
import database.updateSelectiveColumns
import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.mybatis.dynamic.sql.SqlBuilder

fun main() {
    list5_4_3()
}

/**
 * リスト5.4.2
 */
fun createSessionFactory(): SqlSessionFactory {
    val resource = "mybatis-config.xml"
    val inputStream = Resources.getResourceAsStream(resource)
    return SqlSessionFactoryBuilder().build(inputStream)
}

/**
 * リスト5.4.3
 */
fun list5_4_3() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val user = mapper.selectByPrimaryKey(100)
        println(user)
    }
}

/**
 * リスト5.4.4
 */
fun list5_4_4() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val userList = mapper.select {
            where(UserDynamicSqlSupport.User.name, SqlBuilder.isEqualTo("Jiro"))
        }
        println(userList)
    }
}

/**
 * リスト5.4.6
 */
fun list5_4_6() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val userList = mapper.select {
            where(UserDynamicSqlSupport.User.age, SqlBuilder.isGreaterThanOrEqualTo(25))
        }
        println(userList)
    }
}

/**
 * リスト5.4.8
 */
fun list5_4_8() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.count {
            where(UserDynamicSqlSupport.User.age, SqlBuilder.isGreaterThanOrEqualTo(25))
        }
        println(count)
    }
}

/**
 * リスト5.4.9
 */
fun list5_4_9() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.count { allRows() }
        println(count)
    }
}

/**
 * リスト5.4.10
 */
fun list5_4_10() {
    val user = UserRecord(103, "Shiro", 18, "Hello")
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.insert(user)
        session.commit()
        println("${count}行のレコードを挿入しました")
    }
}

/**
 * リスト5.4.12
 */
fun list5_4_12() {
    val userList = listOf(UserRecord(104, "Goro", 15, "Hello"), UserRecord(105, "Rokuro", 13, "Hello"))
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.insertMultiple(userList)
        session.commit()
        println("${count}行のレコードを挿入しました")
    }
}

/**
 * リスト5.4.14
 */
fun list5_4_14() {
    val user = UserRecord(id = 105, profile = "Bye")
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.updateByPrimaryKeySelective(user)
        session.commit()
        println("${count}行のレコードを更新しました")
    }
}

/**
 * リスト5.4.16
 */
fun list5_4_16() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.update {
            set(UserDynamicSqlSupport.User.profile).equalTo("Hey")
            where(UserDynamicSqlSupport.User.id, SqlBuilder.isEqualTo(104))
        }
        session.commit()
        println("${count}行のレコードを更新しました")
    }
}

/**
 * リスト5.4.18
 */
fun list5_4_18() {
    val user = UserRecord(profile = "Good Morning")
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.update {
            updateSelectiveColumns(user)
            where(UserDynamicSqlSupport.User.name, SqlBuilder.isEqualTo("Shiro"))
        }
        session.commit()
        println("${count}行のレコードを更新しました")
    }
}

/**
 * リスト5.4.20
 */
fun list5_4_20() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.deleteByPrimaryKey(102)
        session.commit()
        println("${count}行のレコードを削除しました")
    }
}

/**
 * リスト5.4.22
 */
fun list5_4_22() {
    createSessionFactory().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.delete {
            where(UserDynamicSqlSupport.User.name, SqlBuilder.isEqualTo("Jiro"))
        }
        session.commit()
        println("${count}行のレコードを削除しました")
    }
}
