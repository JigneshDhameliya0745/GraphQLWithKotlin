package com.example.graphqlwithkotlin.controller

import com.example.graphqlwithkotlin.entity.Book
import com.example.graphqlwithkotlin.request.BookRequest
import com.example.graphqlwithkotlin.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController {

    @Autowired
    lateinit var bookService: BookService

    /*
    mutation {
        createBook(bookRequest: {title: "Book Title 3", genre: "Fiction", authorId: 1}) {
            id
            title
            genre
            author {
                id
            }
        }
    }
    */
    @MutationMapping
    fun createBook(@Argument("bookRequest") bookRequest: BookRequest): Book {
        return bookService.createBook(bookRequest)
    }

    /*
    mutation {
        updateBook(bookRequest: {id: 4, title: "Book Title 4", genre: "Fiction", authorId: 1}) {
            id
            title
            genre
            author {
                id
            }
        }
    }
     */
    @MutationMapping
    fun updateBook(@Argument("bookRequest") bookRequest: BookRequest): Book {
        return bookService.updateBook(bookRequest)
    }

    /*
    {
        getAllBooks {
            id
            title
            genre
            author {
                id
            }
        }
    }
     */
    @QueryMapping("getAllBooks")
    fun getAllBooks(): List<Book> {
        return bookService.getAllBooks()
    }

    /*
    {
        getBookById(id: 1) {
        id
        title
        genre
        author {
            id
        }
    }
    }
     */
    @QueryMapping("getBookById")
    fun getBookById(@Argument("id") id: Long): Book {
        return bookService.getBookById(id)
    }

    /*
    mutation {
        deleteBook(
            id: 4
        )
    }
     */
    @MutationMapping
    fun deleteBook(@Argument("id") id: Long): Boolean {
        return bookService.deleteBook(id)
    }
}