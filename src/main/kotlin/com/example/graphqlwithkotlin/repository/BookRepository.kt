package com.example.graphqlwithkotlin.repository

import com.example.graphqlwithkotlin.entity.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long> {
}