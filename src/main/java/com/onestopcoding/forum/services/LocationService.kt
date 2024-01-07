package com.onestopcoding.forum.services

import com.onestopcoding.forum.nodes.location.City
import com.onestopcoding.forum.nodes.location.Country
import com.onestopcoding.forum.nodes.location.Location
import com.onestopcoding.forum.nodes.location.Provence
import com.onestopcoding.forum.repositories.LocationRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service
import java.util.*

@Service
class LocationService(private val locationRepository: LocationRepository) {
    fun save(location: Location): Location {
        return locationRepository.save(location)
    }
    
    fun  saveAll(locations: List<Location>):List<Location>{
        return locationRepository.saveAll(locations)
    }

    //@PostConstruct
    fun createBelgiumLocations() {
        locationRepository.saveAll(listOf(
            Location(UUID.randomUUID(), City("Brussel"), Provence("Brussel-Hoofdstad"), Country("België")),
            Location(UUID.randomUUID(), City("Antwerpen"), Provence("Antwerpen"), Country("België")),
            Location(UUID.randomUUID(), City("Geel"), Provence("Antwerpen"), Country("België")),
            Location(UUID.randomUUID(), City("Herentals"), Provence("Antwerpen"), Country("België")),
            Location(UUID.randomUUID(), City("Hoogstraten"), Provence("Antwerpen"), Country("België")),
            Location(UUID.randomUUID(), City("Lier"), Provence("Antwerpen"), Country("België")),
            Location(UUID.randomUUID(), City("Mechelen"), Provence("Antwerpen"), Country("België")),
            Location(UUID.randomUUID(), City("Mortsel"), Provence("Antwerpen"), Country("België")),
            Location(UUID.randomUUID(), City("Turnhout"), Provence("Antwerpen"), Country("België")),
            Location(UUID.randomUUID(), City("Aat"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Antoing"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Beaumont"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Bergen"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Binche"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Charleroi"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Châtelet"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Chièvres"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Chimay"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Doornik"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Edingen"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Fleurus"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Fontaine-l\'Evêque"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("\'s-Gravenbrakel"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Komen-Waasten"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("La Louvière"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Le Rœulx"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Lessen"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Leuze-en-Hainaut"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Moeskroen"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Péruwelz"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Saint-Ghislain"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Thuin"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Zinnik"), Provence("Henegouwen"), Country("België")),
            Location(UUID.randomUUID(), City("Beringen"), Provence("Limburg"), Country("België")),
            Location(UUID.randomUUID(), City("Bilzen"), Provence("Limburg"), Country("België")),
            Location(UUID.randomUUID(), City("Borgloon"), Provence("Limburg"), Country("België")),
            Location(UUID.randomUUID(), City("Bree"), Provence("Limburg"), Country("België")),
            Location(UUID.randomUUID(), City("Dilsen-Stokkem"), Provence("Limburg"), Country("België")),
            Location(UUID.randomUUID(), City("Genk"), Provence("Limburg"), Country("België")),
            Location(UUID.randomUUID(), City("Halen"), Provence("Limburg"), Country("België")),
            Location(UUID.randomUUID(), City("Hamont-Achel"), Provence("Limburg"), Country("België")),
            Location(UUID.randomUUID(), City("Hasselt"), Provence("Limburg"), Country("België")),
            Location(UUID.randomUUID(), City("Herk-de-Stad"), Provence("Limburg"), Country("België")),
            Location(UUID.randomUUID(), City("Lommel"), Provence("Limburg"), Country("België")),
            Location(UUID.randomUUID(), City("Maaseik"), Provence("Limburg"), Country("België")),
            Location(UUID.randomUUID(), City("Peer"), Provence("Limburg"), Country("België")),
            Location(UUID.randomUUID(), City("Sint-Truiden"), Provence("Limburg"), Country("België")),
            Location(UUID.randomUUID(), City("Tongeren"), Provence("Limburg"), Country("België")),
            Location(UUID.randomUUID(), City("Ans"), Provence("Luik"), Country("België")),
            Location(UUID.randomUUID(), City("Borgworm"), Provence("Luik"), Country("België")),
            Location(UUID.randomUUID(), City("Eupen"), Provence("Luik"), Country("België")),
            Location(UUID.randomUUID(), City("Hannuit"), Provence("Luik"), Country("België")),
            Location(UUID.randomUUID(), City("Herstal"), Provence("Luik"), Country("België")),
            Location(UUID.randomUUID(), City("Herve"), Provence("Luik"), Country("België")),
            Location(UUID.randomUUID(), City("Hoei"), Provence("Luik"), Country("België")),
            Location(UUID.randomUUID(), City("Limburg"), Provence("Luik"), Country("België")),
            Location(UUID.randomUUID(), City("Luik"), Provence("Luik"), Country("België")),
            Location(UUID.randomUUID(), City("Malmedy"), Provence("Luik"), Country("België")),
            Location(UUID.randomUUID(), City("Sankt Vith"), Provence("Luik"), Country("België")),
            Location(UUID.randomUUID(), City("Seraing"), Provence("Luik"), Country("België")),
            Location(UUID.randomUUID(), City("Spa"), Provence("Luik"), Country("België")),
            Location(UUID.randomUUID(), City("Stavelot"), Provence("Luik"), Country("België")),
            Location(UUID.randomUUID(), City("Verviers"), Provence("Luik"), Country("België")),
            Location(UUID.randomUUID(), City("Wezet"), Provence("Luik"), Country("België")),
            Location(UUID.randomUUID(), City("Aarlen"), Provence("Luxemburg"), Country("België")),
            Location(UUID.randomUUID(), City("Aubange"), Provence("Luxemburg"), Country("België")),
            Location(UUID.randomUUID(), City("Bastenaken"), Provence("Luxemburg"), Country("België")),
            Location(UUID.randomUUID(), City("Bouillon"), Provence("Luxemburg"), Country("België")),
            Location(UUID.randomUUID(), City("Chiny"), Provence("Luxemburg"), Country("België")),
            Location(UUID.randomUUID(), City("Durbuy"), Provence("Luxemburg"), Country("België")),
            Location(UUID.randomUUID(), City("Florenville"), Provence("Luxemburg"), Country("België")),
            Location(UUID.randomUUID(), City("Houffalize"), Provence("Luxemburg"), Country("België")),
            Location(UUID.randomUUID(), City("La Roche-en-Ardenne"), Provence("Luxemburg"), Country("België")),
            Location(UUID.randomUUID(), City("Marche-en-Famenne"), Provence("Luxemburg"), Country("België")),
            Location(UUID.randomUUID(), City("Neufchâteau"), Provence("Luxemburg"), Country("België")),
            Location(UUID.randomUUID(), City("Saint-Hubert"), Provence("Luxemburg"), Country("België")),
            Location(UUID.randomUUID(), City("Virton"), Provence("Luxemburg"), Country("België")),
            Location(UUID.randomUUID(), City("Andenne"), Provence("Namen"), Country("België")),
            Location(UUID.randomUUID(), City("Beauraing"), Provence("Namen"), Country("België")),
            Location(UUID.randomUUID(), City("Ciney"), Provence("Namen"), Country("België")),
            Location(UUID.randomUUID(), City("Couvin"), Provence("Namen"), Country("België")),
            Location(UUID.randomUUID(), City("Dinant"), Provence("Namen"), Country("België")),
            Location(UUID.randomUUID(), City("Fosses-la-Ville"), Provence("Namen"), Country("België")),
            Location(UUID.randomUUID(), City("Gembloers"), Provence("Namen"), Country("België")),
            Location(UUID.randomUUID(), City("Namen"), Provence("Namen"), Country("België")),
            Location(UUID.randomUUID(), City("Philippeville"), Provence("Namen"), Country("België")),
            Location(UUID.randomUUID(), City("Rochefort"), Provence("Namen"), Country("België")),
            Location(UUID.randomUUID(), City("Walcourt"), Provence("Namen"), Country("België")),
            Location(UUID.randomUUID(), City("Aalst"), Provence("Oost-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Deinze"), Provence("Oost-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Dendermonde"), Provence("Oost-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Eeklo"), Provence("Oost-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Gent"), Provence("Oost-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Geraardsbergen"), Provence("Oost-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Lokeren"), Provence("Oost-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Ninove"), Provence("Oost-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Oudenaarde"), Provence("Oost-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Ronse"), Provence("Oost-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Sint-Niklaas"), Provence("Oost-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Zottegem"), Provence("Oost-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Aarschot"), Provence("Vlaams-Brabant"), Country("België")),
            Location(UUID.randomUUID(), City("Diest"), Provence("Vlaams-Brabant"), Country("België")),
            Location(UUID.randomUUID(), City("Halle"), Provence("Vlaams-Brabant"), Country("België")),
            Location(UUID.randomUUID(), City("Landen"), Provence("Vlaams-Brabant"), Country("België")),
            Location(UUID.randomUUID(), City("Leuven"), Provence("Vlaams-Brabant"), Country("België")),
            Location(UUID.randomUUID(), City("Scherpenheuvel-Zichem"), Provence("Vlaams-Brabant"), Country("België")),
            Location(UUID.randomUUID(), City("Tienen"), Provence("Vlaams-Brabant"), Country("België")),
            Location(UUID.randomUUID(), City("Vilvoorde"), Provence("Vlaams-Brabant"), Country("België")),
            Location(UUID.randomUUID(), City("Zoutleeuw"), Provence("Vlaams-Brabant"), Country("België")),
            Location(UUID.randomUUID(), City("Geldenaken"), Provence("Waals-Brabant"), Country("België")),
            Location(UUID.randomUUID(), City("Genepiën"), Provence("Waals-Brabant"), Country("België")),
            Location(UUID.randomUUID(), City("Nijvel"), Provence("Waals-Brabant"), Country("België")),
            Location(UUID.randomUUID(), City("Ottignies-Louvain-la-Neuve"), Provence("Waals-Brabant"), Country("België")),
            Location(UUID.randomUUID(), City("Tubeke"), Provence("Waals-Brabant"), Country("België")),
            Location(UUID.randomUUID(), City("Waver"), Provence("Waals-Brabant"), Country("België")),
            Location(UUID.randomUUID(), City("Blankenberge"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Brugge"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Damme"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Diksmuide"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Gistel"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Harelbeke"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Ieper"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Izegem"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Kortrijk"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Lo-Reninge"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Menen"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Mesen"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Nieuwpoort"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Oostende"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Oudenburg"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Poperinge"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Roeselare"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Tielt"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Torhout"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Veurne"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Waregem"), Provence("West-Vlaanderen"), Country("België")),
            Location(UUID.randomUUID(), City("Wervik"), Provence("West-Vlaanderen"), Country("België"))
        ))
    }
    
    fun getLocationsForCountry(country: String):List<Location>{
        return locationRepository.getLocationsByCountry_Name(country)
    }
    
    fun getLocationByCity(city: String): Location {
        return locationRepository.getLocationByCity_Name(city)
    }
}