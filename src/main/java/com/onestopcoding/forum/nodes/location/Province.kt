package com.onestopcoding.forum.nodes.location

import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node

@Node
data class Province(@Id val name: String)
