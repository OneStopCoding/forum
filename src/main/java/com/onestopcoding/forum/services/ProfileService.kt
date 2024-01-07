package com.onestopcoding.forum.services

import com.onestopcoding.forum.models.DMIn
import com.onestopcoding.forum.models.ProfileIn
import com.onestopcoding.forum.nodes.location.City
import com.onestopcoding.forum.nodes.location.Country
import com.onestopcoding.forum.nodes.location.Location
import com.onestopcoding.forum.nodes.location.Provence
import com.onestopcoding.forum.nodes.user.DM
import com.onestopcoding.forum.nodes.user.Profile
import com.onestopcoding.forum.nodes.user.Socials
import com.onestopcoding.forum.repositories.ProfileRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import java.util.*

@Service
open class ProfileService(
    private val profileRepository: ProfileRepository, private val locationService: LocationService,
    private val userService: UserService,
) {

    fun createProfile(profile: ProfileIn): Profile {
        val user = userService.findByUsername(SecurityContextHolder.getContext().authentication.name)
        val location: Location = if (profile.location[2] === "België"){
            locationService.getLocationByCity(profile.location[0])
        }else {
            locationService.save(
                Location(UUID.randomUUID(), City( profile.location[0]), Provence( profile.location[1]), Country(profile.location[2]))
            )
        }
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
        return profileRepository.findProfileByUser_Email(user.getEmail())
    }

    fun getProfileByUsername(username: String): Profile{
        val user = userService.findByUsername(username)
        return profileRepository.findProfileByUser_Email(user.getEmail())
    }

    fun sendDm(message: DMIn): String {
        val sender = userService.findByUsername(SecurityContextHolder.getContext().authentication.name)
        val receiver = userService.findById(message.receiver)
        val profile: Profile = profileRepository.findProfileByUser_Email(receiver.getEmail())
        profile.messages =
            profile.messages.plus(DM(UUID.randomUUID(), sender, receiver, message.title, message.text, message.images))
        val updated = profileRepository.save(profile)
        if (updated.messages.size > profile.messages.size)
            return "Message successfully send"
        return "Failed to send"
    }

    fun follow(username: String):Profile{
        val user = userService.findByUsername(username)
        val follower =  userService.findByUsername(SecurityContextHolder.getContext().authentication.name)
        val profile = profileRepository.findProfileByUser_Email(user.getEmail())
        if(!profile.followers.contains(follower))
        profile.followers = profile.addFollower(follower)
        return profileRepository.save(profile)
    }
}