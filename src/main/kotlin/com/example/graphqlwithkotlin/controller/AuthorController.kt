package com.example.graphqlwithkotlin.controller

import com.example.graphqlwithkotlin.entity.Author
import com.example.graphqlwithkotlin.request.AuthorRequest
import com.example.graphqlwithkotlin.service.AuthorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthorController {

    @Autowired
    lateinit var authorService: AuthorService

    /*
    mutation {
        createAuthor(authorRequest: {
            name: "Author Name",
            books: [
            {
                title: "Book Title 1",
                genre: "Fiction"
            },
            {
                title: "Book Title 2",
                genre: "Science"
            }
            ]
        }) {
            id
            name
            books {
                id
                title
                genre
            }
        }
    }
     */
    @MutationMapping
    fun createAuthor(@Argument("authorRequest") authorRequest: AuthorRequest): Author {
        return authorService.createAuthor(authorRequest)
    }

    /*
    mutation {
        updateAuthor(authorRequest: {
            id: 2
            name: "Author Name1",
            books: [
            {
                title: "Book Title 3",
                genre: "Fiction"
            }
            ]
        }) {
            id
            name
            books {
                id
                title
                genre
            }
        }
    }
     */
    @MutationMapping
    fun updateAuthor(@Argument("authorRequest") authorRequest: AuthorRequest): Author {
        return authorService.updateAuthor(authorRequest)
    }

    /*
    query {
        getAllAuthors {
            id
            name
            books {
                id
                title
            }
        }
    }
     */
    @QueryMapping("getAllAuthors")
    fun getAllAuthors(): List<Author> {
        return authorService.getAllAuthors()
    }

    /*
    query {
        getAuthorById(id: 1) {
            id
            name
            books {
                id
                title
            }
        }
    }
     */
    @QueryMapping("getAuthorById")
    fun getAuthorById(@Argument("id") id: Long): Author {
        return authorService.getAuthorById(id)
    }

    /*
    mutation {
        deleteAuthor(
            id: 2
        )
    }
     */
    @MutationMapping
    fun deleteAuthor(@Argument("id") id: Long): Boolean {
        return authorService.deleteAuthor(id)
    }
}