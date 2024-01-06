package com.onestopcoding.forum.nodes

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import java.util.UUID

@Node
data class Image(
    @Id
    @GeneratedValue(GeneratedValue.UUIDGenerator::class)
    private val id: UUID,
    private val name: String,
    private val description: String,
    private val uri: String
)
