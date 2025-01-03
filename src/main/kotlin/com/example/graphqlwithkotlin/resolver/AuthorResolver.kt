//package com.example.graphqlwithkotlin.resolver
//
//import com.example.graphqlwithkotlin.entity.Author
//import com.example.graphqlwithkotlin.service.AuthorService
//import graphql.kickstart.tools.GraphQLQueryResolver
//import graphql.kickstart.tools.GraphQLMutationResolver
//import org.springframework.stereotype.Component
//
//@Component
//class AuthorResolver(private val authorService: AuthorService) : GraphQLQueryResolver, GraphQLMutationResolver {
//
//    fun authors(): List<Author> = authorService.getAllAuthors()
//
//    fun author(id: Long): Author = authorService.getAuthorById(id)
//
//    fun createAuthor(name: String): Author = authorService.createAuthor(name)
//
//    fun updateAuthor(id: Long, name: String): Author = authorService.updateAuthor(id, name)
//
//    fun deleteAuthor(id: Long): Boolean = authorService.deleteAuthor(id)
//}
