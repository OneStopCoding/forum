package com.onestopcoding.forum.services

import com.onestopcoding.forum.models.CommentIn
import com.onestopcoding.forum.models.PostIn
import com.onestopcoding.forum.nodes.post.Comment
import com.onestopcoding.forum.nodes.post.Post
import com.onestopcoding.forum.repositories.PostRepository
import org.springframework.data.domain.PageRequest
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import java.util.*

@Service
class PostService(private val postRepository: PostRepository, private val userService: UserService) {

    fun addPost(postIn: PostIn): Post {
        val author = userService.findByUsername(SecurityContextHolder.getContext().authentication.name)

        return postRepository.save(Post(UUID.randomUUID(), postIn.title, postIn.body, postIn.images, author))
    }

    private fun findById(id: UUID): Post {
        return postRepository.findById(id).orElseThrow { NoSuchElementException("No post with id $id found!") }
    }

    fun findPostsByUser(username: String): List<Post> {
        return postRepository.findByAuthor_Username(username)
    }

    fun getAllPosts(): List<Post> {
        return postRepository.findAll()
    }

    fun recentPosts(size: Int, page: Int): List<Post>{
        return  postRepository.findAll(PageRequest.of(page, size)).content
    }

    fun addComment(commentIn: CommentIn): Post {
        val user = userService.findByUsername(SecurityContextHolder.getContext().authentication.name)
        val post = findById(commentIn.post)
        post.addComment(Comment(UUID.randomUUID(), commentIn.text, user))
        return postRepository.save(post)
    }
}