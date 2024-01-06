package com.onestopcoding.forum.nodes

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship
import java.util.*

@Node
data class Post(
    @Id
    @GeneratedValue(GeneratedValue.UUIDGenerator::class)
    val id :UUID,
    val title: String,
    var body: String,
    val images: List<String> = mutableListOf(),
    @Relationship(type = "BY", direction = Relationship.Direction.INCOMING)
    val author: User,
    @Relationship(type = "HAS_NONE_OR_MORE", direction = Relationship.Direction.OUTGOING)
    val comments: MutableCollection<Comment> = mutableListOf()
){
    fun addComment(comment: Comment):Post{
        comments.add(comment)
        return this
    }
}