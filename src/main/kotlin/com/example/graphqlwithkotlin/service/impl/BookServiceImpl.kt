package com.example.graphqlwithkotlin.service.impl

import com.example.graphqlwithkotlin.entity.Book
import com.example.graphqlwithkotlin.repository.AuthorRepository
import com.example.graphqlwithkotlin.repository.BookRepository
import com.example.graphqlwithkotlin.request.BookRequest
import com.example.graphqlwithkotlin.service.AuthorService
import com.example.graphqlwithkotlin.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookServiceImpl : BookService {

    @Autowired
    lateinit var bookRepository: BookRepository

    @Autowired
    lateinit var authorRepository: AuthorRepository

    @Autowired
    lateinit var authorService: AuthorService

    override fun <T> createBook(bookRequest: BookRequest): T {
        val book = Book()
        book.title = bookRequest.title
        book.genre = bookRequest.genre

        if (bookRequest.authorId != null) {
            val author = authorService.getAuthorById(bookRequest.authorId!!)
            book.author = author
        } else {
            return "Author doesn't exist!" as T
        }

        return bookRepository.save(book) as T
    }

    override fun <T> updateBook(bookRequest: BookRequest): T {
        return if (bookRequest.id != null) {
            val book = getBookById(bookRequest.id!!)
            book.title = bookRequest.title
            book.genre = bookRequest.genre

            if (bookRequest.authorId != null) {
                val author = authorService.getAuthorById(bookRequest.authorId!!)
                book.author = author
            } else {
                return "Author doesn't exist!" as T
            }

            bookRepository.save(book) as T
        } else {
            "Book ID cannot be null!" as T
        }
    }

    override fun getAllBooks(): List<Book> {
        return bookRepository.findAll()
    }

    override fun getBookById(id: Long): Book {
        val book = bookRepository.findById(id)
        if (book.isPresent) {
            return book.get()
        }
        return Book()
    }

    override fun deleteBook(id: Long): Boolean {
        return if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}