package com.onestopcoding.forum.repositories

import com.onestopcoding.forum.nodes.user.Profile
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.graphql.data.GraphQlRepository
import java.util.UUID

@GraphQlRepository
interface ProfileRepository: Neo4jRepository<Profile, UUID> {

    fun findProfileByUser_Email(email: String): Profile

    fun findProfileByUser_Username(username: String):Profile

}