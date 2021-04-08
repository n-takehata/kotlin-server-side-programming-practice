import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    Database.connect(
        "jdbc:mysql://127.0.0.1:3306/exposed_example",
        driver = "com.mysql.jdbc.Driver",
        user = "root",
        password = "mysql"
    )

    transaction {
        addLogger(StdOutSqlLogger)

        val id = Member.insert {
            it[name] = "Kotlin"
        } get Member.id
        println("Inserted id: $id")
        
        val member = Member.select { Member.id eq id }.single()
        println("id: ${member[Member.id]}")
        println("name: ${member[Member.name]}")
    }
}

object Member : Table("member") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 32)
}