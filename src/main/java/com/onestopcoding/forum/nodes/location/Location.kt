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
    @Relationship(type = "IS_IN", direction = Relationship.Direction.OUTGOING)
    val city: City,
    @Relationship(type = "IS_IN", direction = Relationship.Direction.OUTGOING)
    val provence: Provence,
    @Relationship(type = "IS_IN", direction = Relationship.Direction.OUTGOING)
    val country: Country,
)
