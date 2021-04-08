package example.kotest

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.data.headers
import io.kotest.data.table

class NumberTestByStringSpec : StringSpec() {
    init {
        "isOdd:: when value is odd number then return true" {
            val number = Number(1)
            number.isOdd() shouldBe true
        }

        "isOdd:: when value is even number then return false" {
            val number = Number(2)
            number.isOdd() shouldBe false
        }

        "isRange:: when value in range then return true" {
            forAll(
                table(
                    headers("value"),
                    row(1),
                    row(10)
                )
            ) { value ->
                val number = Number(value)
                number.isRange(1, 10) shouldBe true
            }
        }

        "isRange:: when value not in range then return false" {
            forAll(
                table(
                    headers("value"),
                    row(0),
                    row(11)
                )
            ) { value ->
                val number = Number(value)
                number.isRange(1, 10) shouldBe false
            }
        }

        "isRange:: when value is minimum then return true" {
            val number = Number(1)
            number.isRange(1, 10) shouldBe true
        }

        "isRange:: when value is maximum then return true" {
            val number = Number(10)
            number.isRange(1, 10) shouldBe true
        }
    }
}