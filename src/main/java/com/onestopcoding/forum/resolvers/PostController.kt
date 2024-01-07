package com.onestopcoding.forum.resolvers

import com.onestopcoding.forum.models.CommentIn
import com.onestopcoding.forum.models.PostIn
import com.onestopcoding.forum.nodes.post.Post
import com.onestopcoding.forum.services.PostService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller

@Controller
open class PostController( private val postService: PostService) {

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @MutationMapping
    open fun addPost(@Argument postIn: PostIn): Post {
        return postService.addPost(postIn)
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @MutationMapping
    open fun addComment(@Argument commentIn: CommentIn): Post {
        return postService.addComment(commentIn)
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @QueryMapping
    open fun postsForUser(@Argument author: String): List<Post>{
        return postService.findPostsByUser(author)
    }

    @QueryMapping
    open fun allPosts():List<Post>{
        return postService.getAllPosts()
    }

    @QueryMapping
    fun recentPost(@Argument size: Int, @Argument page: Int): List<Post>{
        return postService.recentPosts(size, page)
    }


}

