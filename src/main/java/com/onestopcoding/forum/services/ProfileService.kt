package com.onestopcoding.forum.services

import com.onestopcoding.forum.models.DMIn
import com.onestopcoding.forum.models.ProfileIn
import com.onestopcoding.forum.nodes.location.City
import com.onestopcoding.forum.nodes.location.Country
import com.onestopcoding.forum.nodes.location.Location
import com.onestopcoding.forum.nodes.location.Province
import com.onestopcoding.forum.nodes.user.DM
import com.onestopcoding.forum.nodes.user.Profile
import com.onestopcoding.forum.nodes.user.Socials
import com.onestopcoding.forum.repositories.DMRepository
import com.onestopcoding.forum.repositories.ProfileRepository
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
open class ProfileService(
    private val profileRepository: ProfileRepository, private val locationService: LocationService,
    private val userService: UserService, private val dmRepository: DMRepository
) {

    fun createProfile(profile: ProfileIn): Profile {
        val user = userService.getLoggedInUser()
        val socials = Socials(
            UUID.randomUUID(), profile.socials[0], profile.socials[1], profile.socials[2],
            profile.socials[3], profile.socials[4]
        )
        val location = Location(
            UUID.randomUUID(),
            City(profile.location[0]),
            Province(profile.location[1]),
            Country(profile.location[2])
        )

       /* val profileExists = profileRepository.findProfileByUser_Email(user.getEmail())
        if (profileExists.user.getEmail() === user.getEmail()) {
            profileExists.firstname = profile.firstname
            profileExists.lastname = profile.lastname
            profileExists.profilePic = profile.profilePic
            profileExists.images = ArrayList(profileExists.images).plus(profile.images)
            if (profileExists.location.city.name !== profile.location[0] ||
                profileExists.location.country.name !== profile.location[2]
            ) {
                profileExists.location = location
            }
            profileExists.socials = socials
            profileExists.bio = profile.bio
            return profileRepository.save(
                profileExists
            )
        } else {*/
            val created = Profile(
                UUID.randomUUID(),
                profile.firstname,
                profile.lastname,
                user,
                profile.profilePic,
                profile.images,
                location,
                socials,
                profile.bio,
                mutableListOf(),
                mutableListOf()
            )
            return profileRepository.save(created)
     //   }
    }

    fun getProfile(): Profile {
        val user = userService.getLoggedInUser()
        return profileRepository.findProfileByUser_Email(user.getEmail())
    }

    fun getProfileByUsername(username: String): Profile {
        return profileRepository.findProfileByUser_Username(username)
    }

    private fun readDM(title: String): Boolean {
        val dm = dmRepository.findDMByTitle(title)
        dm.read = true
        dmRepository.save(dm)
        return true
    }

    fun deleteDM(id: UUID): Boolean {
        dmRepository.deleteById(id)
        return true

    }


    fun getMessages(): List<DM> {
        val profile = getProfile()
        return profile.messages.reversed()
    }

    fun getMessage(title: String): DM {
        readDM(title)
        return dmRepository.findDMByTitle(title)
    }


    fun sendDm(message: DMIn): Profile {
        val sender = userService.getLoggedInUser()
        val receiver = userService.findByUsername(message.receiver)
        val profile: Profile = profileRepository.findProfileByUser_Email(receiver.getEmail())
        profile.messages =
            profile.messages.plus(
                DM(
                    UUID.randomUUID(),
                    sender,
                    receiver,
                    message.title,
                    message.text,
                    message.images
                )
            )
        return profileRepository.save(profile)

    }

    fun follow(username: String): Profile {
        val follower = userService.getLoggedInUser()
        val profile = profileRepository.findProfileByUser_Username(username)
        if (!profile.followers.contains(follower))
            profile.followers = profile.addFollower(follower)
        return profileRepository.save(profile)
    }

    fun getAll(): List<Profile> {
        return profileRepository.findAll()
    }

    fun unFollow(username: String): Profile {
        val profile = getProfileByUsername(username)
        val user = userService.getLoggedInUser()
        val followers = ArrayList(profile.followers)
        followers.remove(user)
        profile.followers = followers
        return profileRepository.save(profile)
    }
}