package com.onestopcoding.forum.nodes

import com.onestopcoding.forum.models.Socials
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import java.util.UUID

@Node
data class Profile(
    @GeneratedValue(GeneratedValue.UUIDGenerator::class)
    @Id
    val id: UUID,
    val firstname: String,
    val lastname: String,
    @Relationship(type = "DETAILS_OF", direction = Relationship.Direction.OUTGOING)
    val user: User,
    @Relationship(type = "IS_FROM", direction = Relationship.Direction.OUTGOING)
    val location: Location,
    val socials: Socials,
    val bio: String,
    @Relationship(type = "HAS_FOLLOWERS", direction = Relationship.Direction.INCOMING)
    val followers: List<User>,
    @Relationship(type = "HAS_MESSAGES", direction = Relationship.Direction.INCOMING)
    var messages: List<DM>
)