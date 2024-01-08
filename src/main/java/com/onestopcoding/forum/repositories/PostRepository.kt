package com.onestopcoding.forum.repositories

import com.onestopcoding.forum.nodes.post.Post
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.graphql.data.GraphQlRepository
import java.util.*

@GraphQlRepository
interface PostRepository: Neo4jRepository<Post, UUID> {

    fun findByAuthor_Email(email: String) : List<Post>

    fun findByAuthor_UsernameOrderByIdDesc(username: String): List<Post>
}