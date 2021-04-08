import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    list11_4_4()
}

/**
 * リスト11.4.2
 */
fun createSessionFactory() {
    Database.connect(
        url = "jdbc:mysql://127.0.0.1:3306/exposed_example",
        driver = "com.mysql.jdbc.Driver",
        user = "root",
        password = "mysql"
    )
}

/**
 * リスト11.4.4
 */
fun list11_4_4() {
    createSessionFactory()
    transaction {
        val list = MemberEntity.all().map { MemberModel(it) }
        list.forEach {
            println(it)
        }
    }
}

/**
 * リスト11.4.5
 */
fun list11_4_5() {
    createSessionFactory()
    transaction {
        val entity = MemberEntity.findById(2)
        entity?.let { println(MemberModel(it)) }
    }
}

/**
 * リスト11.4.6
 */
fun list11_4_6() {
    createSessionFactory()
    transaction {
        val entity = MemberEntity.find { MemberTable.name eq "Saburo" }.map { MemberModel(it) }
        entity?.let { println(it) }
    }
}

/**
 * リスト11.4.7
 */
fun list11_4_7() {
    createSessionFactory()
    transaction {
        val entity = MemberEntity.new {
            name = "Shiro"
        }
        println(MemberModel(entity))
    }
}

/**
 * リスト11.4.8
 */
fun list11_4_8() {
    createSessionFactory()
    transaction {
        val entity = MemberEntity.findById(4)
        entity?.let { it.name = "Yonro" }
    }
}

/**
 * リスト11.4.10
 */
fun list11_4_10() {
    createSessionFactory()
    transaction {
        val entity = MemberEntity.findById(4)
        entity?.let { it.delete() }
    }
}
