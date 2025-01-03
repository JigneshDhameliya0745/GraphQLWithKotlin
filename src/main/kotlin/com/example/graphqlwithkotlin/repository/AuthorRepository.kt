package com.example.graphqlwithkotlin.repository

import com.example.graphqlwithkotlin.entity.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository : JpaRepository<Author, Long> {
}