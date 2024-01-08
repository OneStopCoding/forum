package com.onestopcoding.forum.repositories

import com.onestopcoding.forum.nodes.user.DM
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.graphql.data.GraphQlRepository
import java.util.UUID

@GraphQlRepository
interface DMRepository: Neo4jRepository<DM, UUID> {
    fun findDMByTitle(title: String): DM
}