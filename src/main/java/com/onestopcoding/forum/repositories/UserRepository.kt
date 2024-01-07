package com.onestopcoding.forum.repositories

import com.onestopcoding.forum.nodes.user.User
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.graphql.data.GraphQlRepository

@GraphQlRepository
interface UserRepository: Neo4jRepository<User, String> {

    fun findByUsername(userName: String): User
}