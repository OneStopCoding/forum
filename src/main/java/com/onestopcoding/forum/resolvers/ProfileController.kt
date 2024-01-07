package com.onestopcoding.forum.resolvers

import com.onestopcoding.forum.models.DMIn
import com.onestopcoding.forum.models.ProfileIn
import com.onestopcoding.forum.nodes.user.Profile
import com.onestopcoding.forum.services.ProfileService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller

@Controller
open class ProfileController(private val profileService: ProfileService) {
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @MutationMapping
    open fun createProfile(@Argument profile: ProfileIn): Profile {
        return profileService.createProfile(profile)
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @MutationMapping
    open fun follow(@Argument username: String): Profile {
        return profileService.follow(username)
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @MutationMapping
    open fun sendDM(@Argument dm: DMIn): Profile {
        return profileService.sendDm(dm)
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @MutationMapping
    open fun readDM(@Argument read: Boolean): Boolean {
        return profileService.readDM()
    }

    @QueryMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    open fun getProfile(): Profile {
        return profileService.getProfile()
    }

    @QueryMapping
    open fun getProfileByUsername(@Argument username: String):Profile{
        return profileService.getProfileByUsername(username)
    }
}