package com.book.manager

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("book")
@CrossOrigin(origins = arrayOf("http://localhost:8081"),
    allowCredentials = true.toString()
)
class BookController (
    private val bookService: BookService
) {
    @GetMapping("/list")
    fun getList(): GetBookListResponse {
        val bookList = bookService.getList().map { BookInfo(it) }
        return GetBookListResponse(bookList)
    }
}