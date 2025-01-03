package com.example.graphqlwithkotlin.request

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@AllArgsConstructor
@NoArgsConstructor
@Data
class AuthorRequest {

    var id: Long? = null
    var name: String? = null
    var books: List<BookInputRequest> = mutableListOf()
}