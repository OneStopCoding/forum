package com.onestopcoding.forum.repositories

import com.onestopcoding.forum.nodes.Location
import org.springframework.data.neo4j.repository.Neo4jRepository
import java.util.UUID

interface LocationRepository: Neo4jRepository<Location, UUID> {
}