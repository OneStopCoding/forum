package com.onestopcoding.forum.nodes.user

import com.onestopcoding.forum.nodes.location.Location
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
    var firstname: String,
    var lastname: String,
    @Relationship(type = "DETAILS_OF", direction = Relationship.Direction.OUTGOING)
    val user: User,
    var profilePic: String,
    var images: List<String>,
    @Relationship(type = "IS_FROM", direction = Relationship.Direction.OUTGOING)
    var location: Location,
    var socials: Socials,
    var bio: String,
    @Relationship(type = "HAS_FOLLOWERS", direction = Relationship.Direction.INCOMING)
    var followers: List<User>,
    @Relationship(type = "HAS_MESSAGES", direction = Relationship.Direction.INCOMING)
    var messages: List<DM>
){
    fun addFollower(user: User): List<User> {
        return followers.plus(user)
    }
}
