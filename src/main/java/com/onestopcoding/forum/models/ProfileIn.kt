package com.onestopcoding.forum.models

import java.util.UUID

class ProfileIn(
    val id: UUID,
    val firstname: String,
    val lastname: String,
    val profilePic: String,
    val images: List<String>,
    var location: List<String>,
    var socials: List<String>,
    var bio: String
)

class LocationIn(
    val city: String,
    val provence: String,
    val country: String,
)

class SocialsIn(
   var website: String,
   var github: String,
   var twitter: String,
   var instagram: String,
   var fb: String,
)