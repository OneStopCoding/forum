package com.onestopcoding.forum.repositories

import com.onestopcoding.forum.nodes.post.Comment
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.graphql.data.GraphQlRepository
import java.util.UUID

@GraphQlRepository
interface CommentRepository: Neo4jRepository<Comment, UUID>