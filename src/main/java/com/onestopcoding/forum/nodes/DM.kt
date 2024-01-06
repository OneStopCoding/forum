package com.onestopcoding.forum.nodes

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import java.util.UUID

@Node
data class DM(
    @GeneratedValue(GeneratedValue.UUIDGenerator::class)
    @Id
    val id: UUID,
    val sender: User,
    val receiver: User,
    val title: String,
    val text: String
)
