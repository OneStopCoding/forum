package com.onestopcoding.forum.resolvers

import com.onestopcoding.forum.nodes.User
import com.onestopcoding.forum.services.UserService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller

@Controller
open class UserController(private val userService: UserService) {

    @MutationMapping
    open fun register(@Argument input: User): String{
        return userService.register(input)
    }

    @QueryMapping
    fun helloWorld():String{
        return "Hello World!"
    }

    @QueryMapping
    open fun userByUsername(@Argument username: String): User {
        return userService.findByUsername(username)
    }

    @PreAuthorize("hasRole('ADMIN')")
    @QueryMapping
    open fun allUsers():List<User>{
        return userService.findAll()
    }
}