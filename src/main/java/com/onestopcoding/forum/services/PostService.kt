package com.onestopcoding.forum.services

import com.onestopcoding.forum.models.CommentIn
import com.onestopcoding.forum.models.PostIn
import com.onestopcoding.forum.nodes.post.Comment
import com.onestopcoding.forum.nodes.post.Post
import com.onestopcoding.forum.repositories.CommentRepository
import com.onestopcoding.forum.repositories.PostRepository
import org.springframework.data.domain.PageRequest
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class PostService(
    private val postRepository: PostRepository, private val userService: UserService,
    private val commentRepository: CommentRepository
) {

    fun addPost(postIn: PostIn): Post {
        val author = userService.findByUsername(SecurityContextHolder.getContext().authentication.name)

        return postRepository.save(
            Post(
                UUID.randomUUID(), postIn.title, postIn.body, postIn.images,
                author, mutableListOf(), mutableListOf(), mutableListOf()
            )
        )
    }

    private fun findById(id: UUID): Post {
        return postRepository.findById(id).orElseThrow { NoSuchElementException("No post with id $id found!") }
    }

    fun findPostsByUser(username: String): List<Post> {
        return postRepository.findByAuthor_UsernameOrderByIdDesc(username)
    }

    fun getAllPosts(): List<Post> {
        return postRepository.findAll()
    }

    fun recentPosts(size: Int, page: Int): List<Post> {
        return postRepository.findAll(PageRequest.of(page, size)).content
    }

    fun deletePost(id: UUID): Boolean {
        postRepository.deleteById(id)
        return true
    }

    fun addComment(commentIn: CommentIn): Post {
        val user = userService.findByUsername(SecurityContextHolder.getContext().authentication.name)
        val post = findById(commentIn.post)
        post.addComment(Comment(UUID.randomUUID(), commentIn.text, user, mutableListOf()))
        return postRepository.save(post)
    }

    fun deleteCommentById(id: UUID): Boolean {
        commentRepository.deleteById(id)
        return true
    }

    fun like(id: UUID): Post {
        val post = postRepository.findById(id).get()
        val likes = ArrayList(post.likes)
        val disLikes = ArrayList(post.disLikes)
        val user = userService.getLoggedInUser()
        if (disLikes.contains(user)) {
            disLikes.remove(user)
            post.disLikes = disLikes
        } else if (!likes.contains(user)) {
            likes.add(user)
            post.likes = likes
        }
        return postRepository.save(post)
    }

    fun disLike(id: UUID): Post {
        val post = postRepository.findById(id).get()
        val likes = ArrayList(post.likes)
        val disLikes = ArrayList(post.disLikes)
        val user = userService.getLoggedInUser()
        if (likes.contains(user)) {
            likes.remove(user)
            post.likes = likes
        } else if (!disLikes.contains(user)) {
            disLikes.add(user)
            post.disLikes = disLikes

        }
        return postRepository.save(post)
    }
}
