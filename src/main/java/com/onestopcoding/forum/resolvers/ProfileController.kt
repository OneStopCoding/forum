package com.onestopcoding.forum.resolvers

import com.onestopcoding.forum.models.DMIn
import com.onestopcoding.forum.models.ProfileIn
import com.onestopcoding.forum.nodes.Profile
import com.onestopcoding.forum.services.ProfileService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class ProfileController(private val profileService: ProfileService) {

    @MutationMapping
    fun createProfile(@Argument profile: ProfileIn): Profile {
        return profileService.createProfile(profile)
    }

    @MutationMapping
    fun sendDM(@Argument message: DMIn): String {
        return profileService.sendDm(message)
    }

    @QueryMapping
    fun getProfile(): Profile {
        return profileService.getProfile()
    }
}