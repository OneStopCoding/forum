package com.onestopcoding.forum.services

import com.onestopcoding.forum.models.DMIn
import com.onestopcoding.forum.models.ProfileIn
import com.onestopcoding.forum.nodes.Socials
import com.onestopcoding.forum.nodes.DM
import com.onestopcoding.forum.nodes.Location
import com.onestopcoding.forum.nodes.Profile
import com.onestopcoding.forum.repositories.LocationRepository
import com.onestopcoding.forum.repositories.ProfileRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import java.util.*

@Service
open class ProfileService(
    private val profileRepository: ProfileRepository, private val locationRepository: LocationRepository,
    private val userService: UserService,
) {

    fun createProfile(profile: ProfileIn): Profile {
        val user = userService.findByUsername(SecurityContextHolder.getContext().authentication.name)
        val location = locationRepository.save(
            Location(UUID.randomUUID(), profile.location[0], profile.location[1], profile.location[2])
        )
        val socials = Socials(
            UUID.randomUUID(), profile.socials[0], profile.socials[1], profile.socials[2],
            profile.socials[3], profile.socials[4]
        )
        return profileRepository.save(
            Profile(
                UUID.randomUUID(), profile.firstname, profile.lastname, user, profile.profilePic, profile.images,
                location, socials, profile.bio, mutableListOf(), mutableListOf()
            )
        )
    }

    fun getProfile(): Profile {
        val user = userService.findByUsername(SecurityContextHolder.getContext().authentication.name)
        return profileRepository.findProfileByUser(user)
    }

    fun sendDm(message: DMIn): String {
        val sender = userService.findByUsername(SecurityContextHolder.getContext().authentication.name)
        val receiver = userService.findById(message.receiver)
        val profile: Profile = profileRepository.findProfileByUser(receiver)
        profile.messages = profile.messages.plus(DM(UUID.randomUUID(), sender, receiver, message.title, message.text, message.images))
        val updated = profileRepository.save(profile)
        if (updated.messages.size > profile.messages.size)
            return "Message successfully send"
        return "Failed to send"
    }
}