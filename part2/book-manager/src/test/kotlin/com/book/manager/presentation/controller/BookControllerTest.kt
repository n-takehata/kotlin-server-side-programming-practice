package com.book.manager.presentation.controller

import com.book.manager.application.service.BookService
import com.book.manager.domain.model.Book
import com.book.manager.domain.model.BookWithRental
import com.book.manager.presentation.form.BookInfo
import com.book.manager.presentation.form.GetBookListResponse
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.nio.charset.StandardCharsets
import java.time.LocalDate

internal class BookControllerTest {
    private val bookService = mock<BookService>()
    private val bookController = BookController(bookService)

    @Test
    fun `getList is success`() {
        val bookId = 100L
        val book = Book(bookId, "Kotlin入門", "コトリン太郎", LocalDate.now())
        val bookList = listOf(BookWithRental(book, null))

        whenever(bookService.getList()).thenReturn(bookList)

        val expectedResponse = GetBookListResponse(listOf(BookInfo(bookId, "Kotlin入門", "コトリン太郎", false)))
        val expected = ObjectMapper().registerKotlinModule().writeValueAsString(expectedResponse)
        val mockMvc = MockMvcBuilders.standaloneSetup(bookController).build()
        val resultResponse = mockMvc.perform(get("/book/list")).andExpect(status().isOk).andReturn().response
        val result = resultResponse.getContentAsString(StandardCharsets.UTF_8)

        Assertions.assertThat(expected).isEqualTo(result)
    }
}