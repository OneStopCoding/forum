package com.onestopcoding.forum.resolvers

import com.onestopcoding.forum.models.DMIn
import com.onestopcoding.forum.models.ProfileIn
import com.onestopcoding.forum.nodes.Profile
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
    open fun sendDM(@Argument message: DMIn): String {
        return profileService.sendDm(message)
    }

    @QueryMapping
    open fun getProfile(): Profile {
        return profileService.getProfile()
    }
}