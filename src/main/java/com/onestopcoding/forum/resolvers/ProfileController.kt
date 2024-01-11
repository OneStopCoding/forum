package com.onestopcoding.forum.resolvers

import com.onestopcoding.forum.models.DMIn
import com.onestopcoding.forum.models.ProfileIn
import com.onestopcoding.forum.nodes.user.DM
import com.onestopcoding.forum.nodes.user.Profile
import com.onestopcoding.forum.services.ProfileService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import java.util.UUID

@Controller
open class ProfileController(private val profileService: ProfileService) {
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @MutationMapping
    open fun createProfile(@Argument profile: ProfileIn): Profile {
        return profileService.createProfile(profile)
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

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @MutationMapping
    open fun follow(@Argument username: String): Profile {
        return profileService.follow(username)
    }

    @QueryMapping
    open fun profileById(@Argument id: UUID):Profile{
        return profileService.getProfileById(id)
    }

    @QueryMapping
    open fun allProfile(): List<Profile> {
        return profileService.getAll()
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @MutationMapping
    open fun unFollow(@Argument username: String): Profile {
        return profileService.unFollow(username)
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @MutationMapping
    open fun sendDM(@Argument dm: DMIn): Profile {
        return profileService.sendDm(dm)
    }

    @QueryMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    open fun getDmForUser(): List<DM> {
        return profileService.getMessages()
    }

    @QueryMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    open fun getDM(@Argument title: String): DM {
        return profileService.getMessage(title)
    }

    @MutationMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    open fun deleteDM(@Argument id: UUID):Boolean{
        return profileService.deleteDM(id)
    }
}