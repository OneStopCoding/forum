package com.onestopcoding.forum.models

import com.onestopcoding.forum.nodes.Image

data class PostIn(
    val title: String,
    val body: String,
    val images: List<String>
)