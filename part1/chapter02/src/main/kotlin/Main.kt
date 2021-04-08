import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.reflect.KProperty

fun main() {
    list_2_1_3()
}

/**
 * リスト2.1.1
 */
fun printOddOrEvenNumberText(num: Int) {
    var text = ""
    if (num % 2 == 1) {
        text = "奇数"
    } else {
        text = "偶数"
    }

    println(text)
}

/**
 * リスト2.1.2
 */
//fun printOddOrEvenNumberText(num: Int) {
//    val text = if (num % 2 == 1) {
//        "奇数"
//    } else {
//        "偶数"
//    }
//    println(text)
//}

/**
 * リスト2.1.3
 */
fun list_2_1_3() {
    printOddOrEvenNumberText(100)
    printOddOrEvenNumberText(99)
}

/**
 * リスト2.1.4
 */
//fun printOddOrEvenNumberText(num: Int) {
//    val text = if (num % 2 == 1) "奇数" else "偶数"
//    println(text)
//}

/**
 * リスト2.1.5
 */
fun getOddOrEvenNumberText(num: Int): String {
    if (num % 2 == 1) {
        return "奇数"
    } else {
        return "偶数"
    }
}

/**
 * リスト2.1.6
 */
//fun getOddOrEvenNumberText(num: Int): String {
//    return if (num % 2 == 1) {
//        "奇数"
//    } else {
//        "偶数"
//    }
//}

/**
 * リスト2.1.7
 */
fun printNumText(num: Int) {
    val text = when (num) {
        100 -> {
            "Equal to 100"
        }
        200 -> {
            "Equal to 200"
        }
        else -> {
            "Undefined value"
        }
    }
    println(text)
}

/**
 * リスト2.1.8
 */
fun list2_1_8() {
    printNumText(100)
    printNumText(200)
    printNumText(300)
}

/**
 * リスト2.2.1
 */
class User1 {
    var name: String = ""
}

/**
 * リスト2.2.2
 */
fun list2_2_2() {
    val user = User1()
    user.name = "Takehata"
    println(user.name)
}

/**
 * リスト2.2.3
 */
//class User1 {
//    var name: String = ""
//
//    fun getName(): String {
//        return this.name
//    }
//
//    fun setName(name: String) {
//        this.name = name
//    }
//}

/**
 * リスト2.2.4
 */
//fun list2_2_4() {
//    val user = User1()
//    user.setName("Takehata")
//    println(user.getName())
//}

/**
 * リスト2.2.5
 */
class User2(id: Int) {
    val id: Int = id
    var name: String = ""
}

/**
 * リスト2.2.6
 */
fun list2_2_6() {
    val user = User2(1)
    user.name = "Takehata"
//    user.id = 2 // コンパイルエラー
}

/**
 * リスト2.2.7
 */
class User3 {
    lateinit var name: String
}

/**
 * リスト2.2.8
 */
fun list2_2_8() {
    val user = User3()
    println(user.name)
}

/**
 * リスト2.2.9
 */
class User4 {
    lateinit var name: String
    val isValidName: Boolean
        get() = name != ""
}

/**
 * リスト2.2.10
 */
fun list2_2_10() {
    val user = User4()
    user.name = "Takehata"
    println(user.isValidName)
}

/**
 * リスト2.2.11
 */
class User5 {
    var name: String = ""
        set(value) {
            if (value == "") {
                field = "Kotlin"
            } else {
                field = value
            }
        }
}

/**
 * リスト2.2.12
 */
fun list2_2_12() {
    val user = User5()
    user.name = ""
    println(user.name)
    user.name = "Takehata"
    println(user.name)
}

/**
 * リスト2.3.1
 */
class User6 {
    val id: Int = 1
    val name = "Kotlin"
}

/**
 * リスト2.3.2
 */
fun list2_3_2() {
    val userA = User6()
    val userB = User6()
    println(userA.toString())
    println(userB.toString())
    println(userA == userB)
    val set = hashSetOf(userA)
    println(userA.hashCode())
    println(userB.hashCode())
    println(set.contains(userB))
}

/**
 * リスト2.3.3
 */
//class User6 {
//    val id: Int = 1
//    val name = "Kotlin"
//
//    override fun equals(other: Any?): Boolean {
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//        other as User6
//        if (id != other.id) return false
//        if (name != other.name) return false
//        return true
//    }
//
//    override fun hashCode(): Int {
//        return 31 * name.hashCode() + id
//    }
//
//    override fun toString(): String {
//        return "User6(id=$id, name=$name)"
//    }
//}

/**
 * リスト2.3.5
 */
data class User7(val id: Int, var name: String)

/**
 * リスト2.3.6
 */
fun list2_3_6() {
    val user = User7(1, "Takehata")
    user.name = "Kotlin"
    println(user.name)
}

/**
 * リスト2.3.7
 */
fun list2_3_7() {
    val user = User7(1, "Takehata")
    val same = User7(1, "Takehata")
    val other = User7(2, "Takehata")
    println(user == same)
    println(user == other)
}

/**
 * リスト2.3.8
 */
fun list2_3_8() {
    val user = User7(1, "Takehata")
    val same = User7(1, "Takehata")
    val other = User7(2, "Takehata")

    println("user=${user.hashCode()}")
    println("same=${same.hashCode()}")
    println("other=${other.hashCode()}")

    val set = hashSetOf(user)
    println(set.contains(same))
    println(set.contains(other))
}

/**
 * リスト2.3.9
 */
fun list2_3_9() {
    val user = User7(1, "Takehata")
    println(user.toString())
}

/**
 * リスト2.3.10
 */
fun list2_3_10() {
    val user = User7(1, "Takehata")
    println(user.component1())
    println(user.component2())
}

/**
 * リスト2.3.11
 */
fun list2_3_11() {
    val user = User7(1, "Takehata")
    val updated = user.copy(1, "Kotlin")
    println(updated.toString())
}

/**
 * リスト2.3.12
 */
fun list2_3_12() {
    data class User7(val id: Int, var name: String) {
        val isValidName: Boolean
            get() = name != ""
    }
}

/**
 * リスト2.4.1
 */
fun list2_4_1() {

}

/**
 * リスト2.4.2
 */
fun list2_4_2() {

}

/**
 * リスト2.4.3
 */
fun list2_4_3() {

}

/**
 * リスト2.4.4
 */
fun list2_4_4() {

}

/**
 * リスト2.4.5
 */
fun list2_4_5() {

}

/**
 * リスト2.4.6
 */
fun list2_4_6() {

}

/**
 * リスト2.4.7
 */
fun list2_4_7() {

}

/**
 * リスト2.5.1
 */
fun list2_5_1() {
    val calc: (Int, Int) -> Int = { num1: Int, num2: Int -> num1 + num2 }
}

/**
 * リスト2.5.2
 */
fun list2_5_2() {
    val calc: (Int, Int) -> Int = { num1: Int, num2: Int -> num1 + num2 }
    println(calc(10, 5))
}

/**
 * リスト2.5.3
 */
fun list2_5_3() {
    val calc: (Int, Int) -> Int = { num1, num2 -> num1 + num2 }
}

/**
 * リスト2.5.4
 */
fun list2_5_4() {
    val squared: (Int) -> Int = { it * it }
}

/**
 * リスト2.5.5
 */
fun list2_5_5() {
    val squared: (Int) -> Int = fun(num: Int): Int { return num * num }
}

/**
 * リスト2.5.6
 */
fun printCalcResult(num1: Int, num2: Int, calc: (Int, Int) -> Int) {
    val result = calc(num1, num2)
    println(result)
}

/**
 * リスト2.5.7
 */
fun list2_5_7() {
    printCalcResult(10, 20, { num1, num2 -> num1 + num2 })
    printCalcResult(10, 20, { num1, num2 -> num1 * num2 })
}

/**
 * リスト2.5.8
 */
fun printAddtionResult(x: Int, y: Int) {
    println("足し算の結果を表示します")
    printCalcResult(x, y, { num1, num2 -> num1 + num2 })
}

fun printMultiplicationResult(x: Int, y: Int) {
    println("掛け算の結果を表示します")
    printCalcResult(x, y, { num1, num2 -> num1 * num2 })
}

/**
 * リスト2.5.9
 */
fun list2_5_9() {
    printCalcResult(10, 20) { num1, num2 ->
        num1 + num2
    }
}

/**
 * リスト2.5.10
 */
typealias Calc = (Int, Int) -> Int

/**
 * リスト2.5.11
 */
//fun printCalcResult(num1: Int, num2: Int, calc: Calc) {
//    val result = calc(num1, num2)
//    println(result)
//}

/**
 * リスト2.6.1
 */
fun square(num: Int): Int = num * num
fun list2_6_1() {
    println(square(2))
}

/**
 * リスト2.6.2
 */
//fun Int.square(): Int = this * this
//fun list2_6_2() {
//    println(2.square())
//}

/**
 * リスト2.7.1
 */
fun list2_7_1() {
    val builder = StringBuilder()
    builder.append("oddNumbers: ")
    for (i in 1..10) {
        if (i % 2 == 1) builder.append("$i ")
    }
    val oddNumbers = builder.toString()
    println(oddNumbers)
}

/**
 * リスト2.7.2
 */
fun list2_7_2() {
    val oddNumbers = with(StringBuilder()) {
        this.append("oddNumbers: ")
        for (i in 1..10) {
            if (i % 2 == 1) this.append("$i ")
        }
        this.toString()
    }
    println(oddNumbers)
}

/**
 * リスト2.7.3
 */
fun list2_7_3() {
    val oddNumbers = with(StringBuilder()) {
        append("oddNumbers: ")
        for (i in 1..10) {
            if (i % 2 == 1) append("$i ")
        }
        toString()
    }
    println(oddNumbers)
}

/**
 * リスト2.7.4
 */
fun list2_7_4() {
    val oddNumbers = StringBuilder().run {
        this.append("oddNumbers: ")
        for (i in 1..10) {
            if (i % 2 == 1) this.append("$i ")
        }
        this.toString()
    }
    println(oddNumbers)
}

/**
 * リスト2.7.5
 */
//fun list2_7_5() {
//    fun getUserString(user: User?, newName: String): String? {
//        return user?.run {
//            name = newName
//            toString()
//        }
//    }
//}

/**
 * リスト2.7.6
 */
fun list2_7_6() {
    val oddNumbers = StringBuilder().let { builder ->
        builder.append("oddNumbers: ")
        for (i in 1..10) {
            if (i % 2 == 1) builder.append("$i ")
        }
        builder.toString()
    }
    println(oddNumbers)
}

/**
 * リスト2.7.7
 */
data class User(val name: String)

fun createUser(name: String?): User? {
    return name?.let { n -> User(n) }
}

/**
 * リスト2.7.8
 */
fun list2_7_8() {
    println(createUser("Takehata"))
    println(createUser(null))
}

/**
 * リスト2.7.9
 */
//fun createUser(name: String?): User? {
//    return if (name != null) User(name) else null
//}

/**
 * リスト2.7.10
 */
//fun createUser(name: String?): User? {
//    return name?.let { User(it) }
//}

/**
 * リスト2.7.11
 */
fun list2_7_11() {
    val oddNumbers = StringBuilder().apply {
        this.append("oddNumbers: ")
        for (i in 1..10) {
            if (i % 2 == 1) this.append("$i ")
        }
        this.toString()
    }
    println(oddNumbers)
}

/**
 * リスト2.7.12
 */
//data class User(val id: Int, var name: String, var profile: String)
//fun getUser(id: Int): User {
//    return User(id, "Takehata", "Tokyo")
//}
//fun updateUser(id: Int, newName: String, newProfile: String): User {
//    val user = getUser(id).apply {
//        this.name = newName
//        this.profile = newProfile
//    }
//    println(user)
//}

/**
 * リスト2.7.13
 */
//fun list2_7_13() {
//    updateUser(100, "Kotlin", "Nagoya")
//}

/**
 * リスト2.7.14
 */
//fun updateUser(id: Int, newName: String, newProfile: String): User {
//    val user = getUser(id).apply {
//        name = newName
//        profile = newProfile
//    }
//    println(user)
//}

/**
 * リスト2.7.15
 */
//fun updateUser(id: Int, newName: String, newProfile: String): User {
//    var name = ""
//    val user = getUser(id).apply {
//        name = newName
//        profile = newProfile
//    }
//    println(user)
//}

/**
 * リスト2.7.16
 */
//fun list2_7_16() {
//    updateUser(100, "Kotlin", "Nagoya")
//}

/**
 * リスト2.7.17
 */
//fun updateUser(id: Int, newName: String, newProfile: String): User {
//    val user = getUser(id).also { u ->
//        u.name = newName
//        u.profile = newProfile
//    }
//    println(user)
//}

/**
 * リスト2.7.18
 */
//fun updateUser(id: Int, newName: String, newProfile: String): User {
//    val user = getUser(id).also {
//        it.name = newName
//        it.profile = newProfile
//    }
//    println(user)
//}

/**
 * リスト2.8.1
 */
data class Num(val value: Int) {
    operator fun plus(num: Num): Num {
        return Num(value + num.value)
    }
}

/**
 * リスト2.8.2
 */
fun list2_8_2() {
    val num = Num(5) + Num(1)
    println(num)
}

/**
 * リスト2.8.3
 */
//data class Num(val value: Int) {
// TODO operatorはクラスの中に入れないといけないので、リスト2.8.1(Numクラス)にどう入れ込むか考える
//    operator fun compareTo(num: Num): Int {
//        return value.compareTo(num.value)
//    }
//}

/**
 * リスト2.8.4
 */
//fun list2_8_4() {
//    val greaterThan = Num(5) > Num(1)
//    val lessThan = Num(5) < Num(1)
//    println(greaterThan)
//    println(lessThan)
//}

/**
 * リスト2.9.1
 */
interface CalcurationExecutor {
    val message: String
    fun calc(num1: Int, num2: Int): Int
    fun printStartMessage()
}

class CommonCalcurationExecutor(override val message: String = "calc") : CalcurationExecutor {
    override fun calc(num1: Int, num2: Int): Int {
        throw IllegalStateException("Not implements calc")
    }

    override fun printStartMessage() {
        println("start $message")
    }
}

/**
 * リスト2.9.2
 */
class AddCalcurationExecutor(val calcurationExecutor: CalcurationExecutor) : CalcurationExecutor {
    override val message: String
        get() = calcurationExecutor.message

    override fun calc(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    override fun printStartMessage() {
        calcurationExecutor.printStartMessage()
    }
}

/**
 * リスト2.9.3
 */
fun list2_9_3() {
    val executor = AddCalcurationExecutor(CommonCalcurationExecutor())
    executor.printStartMessage()
    println(executor.calc(8, 11))
}

/**
 * リスト2.9.4
 */
class AddCalcurationExecutorDelegate(val calcurationExecutor: CalcurationExecutor) :
    CalcurationExecutor by calcurationExecutor {
    override fun calc(num1: Int, num2: Int): Int {
        return num1 + num2
    }
}

/**
 * リスト2.9.5
 */
fun list2_9_5() {
    val executorDelegate = AddCalcurationExecutorDelegate(CommonCalcurationExecutor())
    executorDelegate.printStartMessage()
    println(executorDelegate.calc(8, 11))
}

/**
 * リスト2.9.6
 */
class Person {
    var name: String = ""
        get() {
            println("nameを取得します")
            return field
        }
        set(value) {
            println("nameを更新します")
            field = value
        }
    var address: String = ""
        get() {
            println("addressを取得します")
            return field
        }
        set(value) {
            println("addressを更新します")
            field = value
        }
}

/**
 * リスト2.9.7
 */
fun list2_9_7() {
    val person = Person()
    person.name = "Takehata"
    person.address = "Tokyo"
    println(person.name)
    println(person.address)
}

/**
 * リスト2.9.8
 */
class DelegateWithMessage<T> {
    private var value: T? = null
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        println("${property.name}を取得します")
        return value!!
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        println("${property.name}を更新します")
        this.value = value
    }
}

/**
 * リスト2.9.9
 */
class DelegatePerson {
    var name: String by DelegateWithMessage()
    var address: String by DelegateWithMessage()
}

/**
 * リスト2.9.10
 */
fun list2_9_10() {
    val delegatePerson = DelegatePerson()
    delegatePerson.name = "Takehata"
    delegatePerson.address = "Tokyo"
    println(delegatePerson.name)
    println(delegatePerson.address)
}

/**
 * リスト2.9.11
 */
class DelegateWithMessageString {
    private var value: String? = null
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("${property.name}を取得します")
        return value!!
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("${property.name}を更新します")
        this.value = value
    }
}

/**
 * リスト2.10.1
 */
//data class User(val id: Int, val teamId: Int, val name: String)

/**
 * リスト2.10.2
 */
fun list2_10_2() {
    val list = listOf(1, 2, 3)
    list.forEach { num -> println(num) }
}

/**
 * リスト2.10.3
 */
fun list2_10_3() {
    val list = listOf(1, 2, 3)
    list.forEach { println(it) }
}

/**
 * リスト2.10.4
 */
fun list2_10_4() {
    val list = listOf(1, 2, 3)
    val idList = list.map { it * 10 }
    idList.forEach { println(it) }
}

/**
 * リスト2.10.5
 */
//fun list2_10_5() {
//    val list = listOf(User(1, 100, "Takehata"), User(2, 200, "Kotlin"))
//    val idList = list.map { it.id }
//    idList.forEach { println(it) }
//}

/**
 * リスト2.10.6
 */
//fun list2_10_6() {
//    val list = listOf(User(1, 100, "Takehata"), User(2, 200, "Kotlin"), User(3, 100, "Java"))
//    val filteredList = list.filter { it.teamId == 100 }
//    filteredList.forEach { println(it) }
//}

/**
 * リスト2.10.7
 */
//fun list2_10_7() {
//    val list = listOf(User(1, 100, "Takehata"), User(2, 200, "Kotlin"), User(3, 100, "Java"), User(4, 200, "Groovy"))
//    println(list.first())
//    println(list.last())
//}

/**
 * リスト2.10.8
 */
//fun list2_10_8() {
//    println(list.first { it.teamId == 200 })
//    println(list.last { it.teamId == 100 })
//}

/**
 * リスト2.10.9
 */
//fun list2_10_9() {
//    val list = listOf(User(1, 100, "Takehata"), User(2, 200, "Kotlin"), User(3, 100, "Java"), User(4, 200, "Groovy"))
//    println(list.firstOrNull { it.teamId == 200 })
//    println(list.lastOrNull { it.teamId == 100 })
//    println(list.firstOrNull { it.teamId == 1000 })
//    println(list.lastOrNull { it.teamId == 1000 })
//}

/**
 * リスト2.10.10
 */
fun list2_10_10() {
    val list = listOf(1, 1, 2, 3, 4, 4, 5)
    val distinctList = list.distinct()
    distinctList.forEach { println(it) }
}

/**
 * リスト2.10.11
 */
//fun list2_10_11() {
//    val list = listOf(User(1, 100, "Takehata"), User(2, 200, "Kotlin"), User(3, 100, "Java"))
//    val map = list.associateBy { it.id }
//    println(map)
//    // mapの各要素をidをキーに取得し出力
//    list.forEach { println(map[it.id]) }
//}

/**
 * リスト2.10.12
 */
fun list2_10_12() {
    val list = listOf("Takehata", "Kotlin", "Java")
    val map = list.associateWith { it.length }
    println(map)
    // mapの各要素を文字列をキーに取得し出力
    list.forEach { println(map[it]) }
}

/**
 * リスト2.10.13
 */
//fun list2_10_13() {
//    val list = listOf(User(1, 100, "Takehata"), User(2, 200, "Kotlin"), User(3, 100, "Java"), User(4, 200, "Groovy"))
//    val map = list.groupBy { it.teamId }
//    println(map)
//    println(map[100])
//    println(map[200])
//}

/**
 * リスト2.10.14
 */
fun list2_10_14() {
    val list = listOf(1, 2, 3, 4, 5)
    val oddNumberCount = list.count { it % 2 == 1 }
    println(oddNumberCount)
}

/**
 * リスト2.10.15
 */
fun list2_10_15() {
    val list = listOf("Takehata", "Kotlin", "Java", "Groovy", "Scala")
    val chunkedList = list.chunked(2)
    println(chunkedList)
    chunkedList.forEach { println(it) }
}

/**
 * リスト2.10.16
 */
fun list2_10_16() {
    val list = listOf(1, 2, 3, 4, 5)
    val result = list.reduce { sum, value ->
        println("$sum + $value")
        sum + value
    }
    println(result)
}

/**
 * リスト2.10.17
 */
fun list2_10_17() {
    val list = listOf(1, 2, 3, 4, 5)
    val result = list.reduce { sum, value -> sum * value }
    println(result)
}

/**
 * リスト2.10.18
 */
fun list2_10_18() {
    val list = listOf("a", "b", "c", "d", "e")
    val result = list.reduce { line, str -> line + str }
    println(result)
}

/**
 * リスト2.11.2
 */
fun list2_11_2() {
    GlobalScope.launch {
        delay(1000L)
        println("Naoto.")
    }
    println("My name is")
    Thread.sleep(2000L)
}

/**
 * リスト2.11.3
 */
fun list2_11_3() {
    runBlocking {
        launch {
            delay(1000L)
            println("Naoto.")
        }
        println("My name is")
    }
}

/**
 * リスト2.11.4
 */
//fun printName() {
//    delay(1000L) // コンパイルエラー
//    println("Naoto.")
//}

/**
 * リスト2.11.5
 */
suspend fun printName() {
    delay(1000L)
    println("Naoto.")
}

/**
 * リスト2.11.6
 */
fun list2_11_6() {
    runBlocking {
        launch { printName() }
        println("My name is")
    }
}

/**
 * リスト2.11.7
 */
fun list2_11_7() {
    runBlocking {
        val result = async {
            delay(2000L)
            var sum = 0
            for (i in 1..10) {
                sum += i
            }
            sum
        }
        println("計算中")
        println("sum=${result.await()}")
    }
}

/**
 * リスト2.11.8
 */
fun list2_11_8() {
    runBlocking {
        val num1 = async {
            delay(2000L)
            1 + 2
        }
        val num2 = async {
            delay(1000L)
            3 + 4
        }
        println("sum=${num1.await() + num2.await()}")
    }
}
