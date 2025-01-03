package com.example.graphqlwithkotlin.request

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@AllArgsConstructor
@NoArgsConstructor
@Data
class BookRequest {

    var id: Long? = null
    var title: String? = null
    var genre: String = ""
    var authorId: Long? = null
}