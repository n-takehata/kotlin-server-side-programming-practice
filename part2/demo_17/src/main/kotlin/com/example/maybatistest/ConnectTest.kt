package com.example.maybatistest

import com.example.demo.database.*
import database.*
import com.example.demo.database.UserDynamicSqlSupport.User.age
import com.example.demo.database.UserDynamicSqlSupport.User.name
import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.mybatis.dynamic.sql.SqlBuilder.isGreaterThanOrEqualTo

fun createSessionFactroy(): SqlSessionFactory {
    val resource = "mybatis-config.xml"
    val inputStream = Resources.getResourceAsStream(resource)
    return SqlSessionFactoryBuilder().build(inputStream)
}

fun main(args: Array<String>) {
    createSessionFactroy().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val user = mapper.selectByPrimaryKey(100)
        println(user)
    }

    // select with where
    createSessionFactroy().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val userList = mapper.select {
            where (name, isEqualTo("Bob"))
        }
        println(userList)
    }

    // select by age
    createSessionFactroy().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val userList = mapper.select {
            where (age, isGreaterThanOrEqualTo(19))
        }
        println(userList)
    }

    // count users that age >= 19
    createSessionFactroy().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.count {
            where (age, isGreaterThanOrEqualTo(19))
        }
        println(count)
    }

    // count allrows
    createSessionFactroy().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.count {
            allRows()
        }
        println(count)
    }

    // insert record
    val user = UserRecord(103, "Mike", 20, "Goodbye")
    createSessionFactroy().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.insert(user)
        session.commit()
        println("${count} rows inserted")
    }

    // update record
    val user2 = UserRecord(id=103, profile="Hello")
    createSessionFactroy().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.updateByPrimaryKeySelective(user2)
        session.commit()
        println("${count} rows updated")
    }

    // select allrows
    createSessionFactroy().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val userList = mapper.select {
            allRows()
        }
        println(userList)
    }

    // delete record
    createSessionFactroy().openSession().use { session ->
        val mapper = session.getMapper(UserMapper::class.java)
        val count = mapper.deleteByPrimaryKey(103)
        session.commit()
        println("${count} rows deleted")
    }
}