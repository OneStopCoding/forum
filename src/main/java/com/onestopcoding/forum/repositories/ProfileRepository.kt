package com.onestopcoding.forum.repositories

import com.onestopcoding.forum.nodes.user.Profile
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProfileRepository: Neo4jRepository<Profile, UUID> {

    fun findProfileByUser_Email(email: String): Profile
}