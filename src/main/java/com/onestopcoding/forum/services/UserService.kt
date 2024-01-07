package com.onestopcoding.forum.services

import com.onestopcoding.forum.nodes.user.User
import com.onestopcoding.forum.repositories.UserRepository
import com.onestopcoding.forum.security.JwtUtil
import com.onestopcoding.forum.security.RSAKeyProperties
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository, private val rsaKeys: RSAKeyProperties, private val passwordEncoder: PasswordEncoder) {

    fun register(user: User): String {
        val passwordString = user.getPassword()
        user.setPassword(passwordEncoder.encode(user.getPassword()))
        val registeredUser = userRepository.save(user)
        return  login(registeredUser.getUsername(), passwordString)
    }

    fun login(username: String, password: String): String {
        val user = userRepository.findByUsername(username)
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw BadCredentialsException("Bad password!")
        }
        return JwtUtil.generateToken(
            username = username,
            signedSecret = rsaKeys.publicKey.toString(),
            roles = user.getRoles().split(",")
        )
    }

    fun findByUsername(username: String): User {
        return userRepository.findByUsername(username)
    }

    fun findById(id: String): User {
        return userRepository.findById(id).orElseThrow { NoSuchElementException("user with id: $id could not be found!") }
    }

    fun findAll ():List<User>{
        return userRepository.findAll();
    }

}