fun main() {
    list1_3_1()
}

/**
 * リスト1.3.1
 */
fun list1_3_1() {
//    val str1: String = null // Null非許容、コンパイルエラーになる
    val str2: String? = null // Null許容
}

/**
 * リスト1.3.2
 */
fun printMessageLength(message: String?) {
//    println(message.length) // コンパイルエラー
}

/**
 * リスト1.3.3
 */
fun printMessageLength2(message: String?) {
    if (message == null) {
        return
    }
    // 上の処理でNullでないことが保証されているので実行できる
    println(message.length)
}

/**
 * リスト1.3.4
 */
fun execute(userId: Int?) {
//    createUser(userId) // コンパイルエラー
}

private fun createUser(userId: Int) {
    // 省略
}

/**
 * リスト1.3.5
 */
//fun execute(userId: Int?) {
//    if (userId != null) {
//        createUser(userId)
//    }
//}

/**
 * リスト1.3.6
 */
fun execute(userId: Int) {
    createUser(userId)
}

/**
 * リスト1.3.7
 */
//fun printMessageLength(message: String?) {
//    println(message?.length)
//}

/**
 * リスト1.3.8
 */
fun list1_3_8() {
    printMessageLength("Kotlin")
    printMessageLength(null)
}

/**
 * リスト1.3.9
 */
//fun printMessageLength(message: String?) {
//    println(message!!.length)
//}

/**
 * リスト1.3.4
 */
fun printMessageLength3(message: String?) {
    message ?: return
    println(message.length)
}

/**
 * リスト1.5.1
 */
fun list1_5_1() {
    val id = 100
    var name = "Takehata"
}

/*
 * リスト1.5.2
 */
//fun list1_5_2() {
//    val id = 100
//    id = 200 // コンパイルエラー
//}

/**
 * リスト1.5.3
 */
fun list1_5_3() {
    val id: Int = 100
    var name: String = "Takehata"
}

/**
 * リスト1.5.4
 */
fun countLength(str: String): Int {
    return str.length
}

/**
 * リスト1.5.5
 */
fun displayMessage(message: String) {
    println(message)
}

/**
 * リスト1.5.6
 */
//fun displayMessage(message: String): Unit {
//    println(message)
//}

/**
 * リスト1.5.7
 */
fun ifExample(num: Int) {
    if (num == 100) {
        println("num is 100")
    }
}

/**
 * リスト1.5.8
 */
//fun ifExample(num: Int) {
//    if (num < 100) {
//        println("Less than 100")
//    } else if (num == 100) {
//        println("Equal to 100")
//    } else {
//        println("Greater than 100")
//    }
//}

/**
 * リスト1.5.9
 */
fun whenExample(num: Int) {
    when (num) {
        100 -> {
            println("Equal to 100")
        }
        200 -> {
            println("Equal to 200")
        }
        else -> {
            println("Undefined value")
        }
    }
}

/**
 * リスト1.5.10
 */
//fun whenExample(num: Int) {
//    when {
//        num < 100 -> {
//            println("Less than 100")
//        }
//        num == 100 -> {
//            println("Equal to 100")
//        }
//        else -> {
//            println("Greater than 100")
//        }
//    }
//}

/**
 * リスト1.5.11
 */
fun list1_5_11() {
    var i = 1
    while (i < 10) {
        println("i is $i")
        i++
    }
}

/**
 * リスト1.5.12
 */
fun list1_5_12() {
    for (i in 1..10) {
        println("i is $i")
    }
}

/**
 * リスト1.5.13
 */
fun list1_5_13() {
    for (i in 1 until 10 step 2) {
        println("i is $i")
    }
}

/**
 * リスト1.5.14
 */
fun list1_5_14() {
    val list = listOf(1,2,5,6,10)
    for (i in list) {
        println("i is $i")
    }
}

/**
 * リスト1.5.15
 */
class Human {
    fun showName(name: String) {
        println()
    }
}

/**
 * リスト1.5.16
 */
fun list1_5_16() {
    val human = Human()
    human.showName("Takehata")
}

/**
 * リスト1.5.17
 */
//class Human(val name: String) {
//    fun showName() {
//        println(name)
//    }
//}

/**
 * リスト1.5.18
 */
//fun list1_5_18() {
//    val human = Human("Takehata")
//    human.showName()
//}

/**
 * リスト1.5.19
 */
open class Animal(val name: String) {
    fun showName() = println("name is $name")
    open fun cries() = println("")
}

/**
 * リスト1.5.20
 */
class Dog(name: String) : Animal(name) {
    override fun cries() = println("bowwow")
}

/**
 * リスト1.5.21
 */
//class Dog(name: String, age: Int) : Animal(name) {
//// 省略
//}

/**
 * リスト1.5.22
 */
sealed class Platform {
    abstract fun showName()
}

/**
 * リスト1.5.23
 */
//sealed class Platform {
//    abstract fun showName()
//}
class AndroidPlatform: Platform() {
    override fun showName() {
        println("Android.")
    }
}
class IosPlatform: Platform() {
    override fun showName() {
        println("iOS.")
    }
}

/**
 * リスト1.5.24
 */
interface Greeter {
    fun hello()
}

/**
 * リスト1.5.25
 */
class GreeterImpl: Greeter {
    override fun hello() {
        println("Hello.")
    }
}

/**
 * リスト1.5.26
 */
fun list1_5_26() {
    val intList: List<Int> = listOf<Int>(1, 2, 3)
    println(intList)
    println(intList[1])

    val stringList: List<String> = listOf<String>("one", "two", "three")
    println(stringList)
    println(stringList[1])
}

/**
 * リスト1.5.27
 */
fun list1_5_27() {
    val intList = listOf(1, 2, 3)
    val stringList = listOf("one", "two", "three")
}

/**
 * リスト1.5.28
 */
fun list1_5_28() {
//    val immutableList: List<Int> = listOf(1, 2, 3)
//    immutableList.add(4) // コンパイルエラー
    val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)
    mutableList.add(4)
}

/**
 * リスト1.5.29
 */
fun list1_5_29() {
    val map: Map<Int, String> = mapOf(1 to "one", 2 to "two", 3 to "three")
    println(map)
    println(map[2])
}

/**
 * リスト1.5.30
 */
fun list1_5_30() {
    val map = mapOf(1 to "one", 2 to "two", 3 to "three")
    println(map.containsKey(3))
    println(map.containsKey(4))
}

/**
 * リスト1.5.31
 */
fun list1_5_31() {
//    val immutableMap: Map<Int, String> = mapOf(1 to "one", 2 to "two", 3 to "three")
//    immutableMap[4] = "four" // コンパイルエラー
    val mutableMap: MutableMap<Int, String> = mutableMapOf(1 to "one", 2 to "two", 3 to "three")
    mutableMap[4] = "four"
}

/**
 * リスト1.5.32
 */
fun list1_5_32() {
    val set = setOf("one", "two", "three")
    println(set)
}

/**
 * リスト1.5.33
 */
fun list1_5_33() {
    val set = setOf("one", "two", "three")
    println(set.contains("three"))
    println(set.contains("four"))
}

/**
 * リスト1.5.34
 */
fun list1_5_34() {
//    val immutableSet = setOf("one", "two", "three")
//    immutableSet.add("four") // コンパイルエラー
    val mutableSet = mutableSetOf("one", "two", "three")
    mutableSet.add("four")
}
