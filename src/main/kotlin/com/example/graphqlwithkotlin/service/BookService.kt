package com.example.graphqlwithkotlin.service

import com.example.graphqlwithkotlin.entity.Book
import com.example.graphqlwithkotlin.request.BookRequest

interface BookService {

    fun <T> createBook(bookRequest: BookRequest): T
    fun <T> updateBook(bookRequest: BookRequest): T
    fun getAllBooks(): List<Book>
    fun getBookById(id: Long): Book
    fun deleteBook(id: Long): Boolean
}