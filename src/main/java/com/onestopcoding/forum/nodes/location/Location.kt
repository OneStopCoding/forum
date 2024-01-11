package com.onestopcoding.forum.nodes.location

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import java.util.UUID

@Node
data class Location(
    @GeneratedValue(GeneratedValue.UUIDGenerator::class)
    @Id
    val id: UUID,
    @Relationship(type = "IS_IN_CITY", direction = Relationship.Direction.OUTGOING)
    val city: City,
    @Relationship(type = "IS_IN_PROVINCE", direction = Relationship.Direction.OUTGOING)
    val province: Province,
    @Relationship(type = "IS_IN_COUNTRY", direction = Relationship.Direction.OUTGOING)
    val country: Country,
)
