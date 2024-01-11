package com.onestopcoding.forum.resolvers

import com.onestopcoding.forum.nodes.location.City
import com.onestopcoding.forum.nodes.location.Location
import com.onestopcoding.forum.nodes.location.Province
import com.onestopcoding.forum.services.LocationService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class LocationController (private val locationService: LocationService){

    @QueryMapping
    fun allLocations():List<Location>{
        return locationService.getAll()
    }

    @QueryMapping
    fun locationsPerCountry(@Argument country: String):List<Location>{
        return locationService.getLocationByCountry(country)
    }

    @QueryMapping
    fun locationsPerProvence(@Argument provence: String):List<Location>{
        return locationService.getLocationsByProvence(provence)
    }

    @QueryMapping
    fun provincesPerCountry(@Argument country: String):List<Province>{
        return locationService.getProvincesByCountry(country)
    }

    @QueryMapping
    fun citiesPerProvince(@Argument province: String):List<City>{
        return locationService.getCitiesByProvince(province)
    }

    @QueryMapping
    fun locationsPerCity(@Argument city: String): List<Location>{
        return locationService.getLocationByCity(city)
    }

    @QueryMapping
    fun allProvinces():List<Province>{
        return locationService.allProvinces()
    }

    @QueryMapping
    fun allCities(): List<City>{
        return locationService.allCities()
    }
}