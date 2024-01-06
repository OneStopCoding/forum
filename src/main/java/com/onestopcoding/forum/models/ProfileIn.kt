package com.onestopcoding.forum.models

import java.util.UUID

class ProfileIn(
    val firstname: String,
    val lastname: String,
    var location: LocationIn,
    var socials: SocialsIn,
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