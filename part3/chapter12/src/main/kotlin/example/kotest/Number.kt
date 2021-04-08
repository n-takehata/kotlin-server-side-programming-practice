package example.kotest

data class Number(val value: Int) {
    fun isOdd(): Boolean {
        return value % 2 == 1
    }

    fun isRange(min: Int, max: Int): Boolean {
        return value in min..max
    }
}