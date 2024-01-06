package com.onestopcoding.forum.services

import com.onestopcoding.forum.models.DMIn
import com.onestopcoding.forum.models.ProfileIn
import com.onestopcoding.forum.models.Socials
import com.onestopcoding.forum.nodes.DM
import com.onestopcoding.forum.nodes.Location
import com.onestopcoding.forum.nodes.Profile
import com.onestopcoding.forum.repositories.LocationRepository
import com.onestopcoding.forum.repositories.ProfileRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProfileService(
    private val profileRepository: ProfileRepository, private val locationRepository: LocationRepository,
    private val userService: UserService,
) {

    fun createProfile(profile: ProfileIn): Profile {
        val user = userService.findByUsername(SecurityContextHolder.getContext().authentication.name)
        val location = locationRepository.save(
            Location(UUID.randomUUID(), profile.location.city, profile.location.provence, profile.location.country)
        )
        val socials = Socials(
            profile.socials.website, profile.socials.github, profile.socials.twitter,
            profile.socials.instagram, profile.socials.fb
        )
        return profileRepository.save(
            Profile(
                UUID.randomUUID(), profile.firstname, profile.lastname, user,
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
        profile.messages = profile.messages.plus(DM(UUID.randomUUID(), sender, receiver, message.title, message.text))
        val updated = profileRepository.save(profile)
        if (updated.messages.size > profile.messages.size)
            return "Message successfully send"
        return "Failed to send"
    }
}