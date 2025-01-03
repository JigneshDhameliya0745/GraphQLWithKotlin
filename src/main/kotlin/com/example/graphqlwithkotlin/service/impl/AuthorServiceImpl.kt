package com.example.graphqlwithkotlin.service.impl

import com.example.graphqlwithkotlin.entity.Author
import com.example.graphqlwithkotlin.entity.Book
import com.example.graphqlwithkotlin.repository.AuthorRepository
import com.example.graphqlwithkotlin.request.AuthorRequest
import com.example.graphqlwithkotlin.service.AuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl : AuthorService {

    @Autowired
    lateinit var authorRepository: AuthorRepository

    override fun <T> createAuthor(authorRequest: AuthorRequest): T {
        val author = Author()
        author.name = authorRequest.name

        val books = authorRequest.books.map { bookInput ->
            val book = Book()
            book.title = bookInput.title
            book.genre = bookInput.genre
            book.author = author
            book
        }

        author.books = books

        return authorRepository.save(author) as T
    }

    override fun <T> updateAuthor(authorRequest: AuthorRequest): T {
        return if (authorRequest.id != null) {
            val author = getAuthorById(authorRequest.id!!)
            author.name = authorRequest.name

            val books = authorRequest.books.map { bookInput ->
                val book = Book()
                book.title = bookInput.title
                book.genre = bookInput.genre
                book.author = author
                book
            }

            author.books = books

            authorRepository.save(author) as T
        } else {
            "Author ID cannot be null!" as T
        }
    }

    override fun getAllAuthors(): List<Author> {
        return authorRepository.findAll()
    }

    override fun getAuthorById(id: Long): Author {
        val author = authorRepository.findById(id)
        if (author.isPresent) {
            return author.get()
        }
        return Author()
    }

    override fun deleteAuthor(id: Long): Boolean {
        return if (authorRepository.existsById(id)) {
            authorRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}