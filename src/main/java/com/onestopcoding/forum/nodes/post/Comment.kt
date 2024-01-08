package com.onestopcoding.forum.nodes.post

import com.onestopcoding.forum.nodes.user.User
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import java.util.*

@Node
data class Comment (
    @Id
    @GeneratedValue(GeneratedValue.UUIDGenerator::class)
    val id: UUID,
    var text: String,
    @Relationship(type = "BY", direction = Relationship.Direction.INCOMING)
    val author: User,
    @Relationship(type = "LIKES", direction = Relationship.Direction.INCOMING)
    var likes:List<User>,

)