package com.onestopcoding.forum.nodes.user

import org.springframework.data.neo4j.core.schema.Id
import java.util.UUID


class Socials(
    @Id
    val id: UUID,
    val website: String,
    val github: String,
    val twitter: String,
    val instagram: String,
    val fb: String
    )