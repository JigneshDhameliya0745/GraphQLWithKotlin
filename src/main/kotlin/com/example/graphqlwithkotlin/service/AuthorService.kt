package com.example.graphqlwithkotlin.service

import com.example.graphqlwithkotlin.entity.Author
import com.example.graphqlwithkotlin.request.AuthorRequest

interface AuthorService {

    fun <T> createAuthor(authorRequest: AuthorRequest): T
    fun <T> updateAuthor(authorRequest: AuthorRequest): T
    fun getAllAuthors(): List<Author>
    fun getAuthorById(id: Long): Author
    fun deleteAuthor(id: Long): Boolean
}