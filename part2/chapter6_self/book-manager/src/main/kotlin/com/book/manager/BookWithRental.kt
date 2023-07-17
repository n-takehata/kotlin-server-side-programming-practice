package com.book.manager

data class BookWithRental(
    val book: Book,
    val Rental: Rental?
) {
    val isRental: Boolean
        get() = Rental != null
}
