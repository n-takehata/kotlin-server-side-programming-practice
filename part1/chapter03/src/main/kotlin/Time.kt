import java.time.LocalDateTime

/**
 * リスト3.2.2
 */
data class Time(val time: LocalDateTime)
fun main() {
    val now = Time(LocalDateTime.now())
    println(now.time)
}