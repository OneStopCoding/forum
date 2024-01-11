package com.onestopcoding.forum.repositories

import com.onestopcoding.forum.nodes.location.Location
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.graphql.data.GraphQlRepository
import java.util.UUID

@GraphQlRepository
interface LocationRepository: Neo4jRepository<Location, UUID> {
    fun getLocationsByCountry_Name(countryName: String):List<Location>

    fun getLocationsByCity_Name(cityName: String): List<Location>

    fun getLocationsByProvince_Name(provinceName: String):List<Location>
}