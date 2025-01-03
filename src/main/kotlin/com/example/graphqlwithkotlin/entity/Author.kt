package com.example.graphqlwithkotlin.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var name: String? = null

//    @OneToMany(mappedBy = "author", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "author", targetEntity = Book::class, cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var books: List<Book> = mutableListOf()
}