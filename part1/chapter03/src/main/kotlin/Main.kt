import java.util.UUID

fun main() {
    list3_1_2()
}

/**
 * リスト3.1.2
 */
fun list3_1_2() {
    val hello = HelloByJava()
    hello.printHello()
}

/**
 * リスト3.2.1
 */
fun list3_2_1() {
    val uuid: UUID = UUID.randomUUID()
    println(uuid.toString())
}

/**
 * リスト3.3.3
 */
fun list3_3_3() {
    val dog = DogKotlin()
    dog.cry()
}

/**
 * リスト3.3.6
 */
fun list3_3_6() {
    val greeter = GreeterImplKotlin()
    greeter.hello()
}

/**
 * リスト3.4.2
 */
fun list3_4_2() {
    val user = UserJava()
    user.id = 100
    user.name = "Takehata"
    println(user.id)
    println(user.name)
}

/**
 * リスト3.4.4
 */
fun list3_4_4() {
    val function = CalcJava { num1, num2 -> num1 + num2 }
    println(function.calc(1, 3))
}

/**
 * リスト3.4.5
 */
fun executeCalc(num1: Int, num2: Int, function: CalcJava) {
    println(function.calc(num1, num2))
}

fun list3_4_5() {
    executeCalc(1, 3, CalcJava { num1, num2 -> num1 + num2 })
    val function = CalcJava { num1, num2 -> num1 + num2 }
}

