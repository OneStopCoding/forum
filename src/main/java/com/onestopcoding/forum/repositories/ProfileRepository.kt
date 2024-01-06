package com.onestopcoding.forum.repositories

import com.onestopcoding.forum.nodes.Profile
import com.onestopcoding.forum.nodes.User
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProfileRepository: Neo4jRepository<Profile, UUID> {

    fun findProfileByUser(user: User):Profile
}