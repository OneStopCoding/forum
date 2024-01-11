package com.onestopcoding.forum.services

import com.onestopcoding.forum.nodes.location.City
import com.onestopcoding.forum.nodes.location.Country
import com.onestopcoding.forum.nodes.location.Location
import com.onestopcoding.forum.nodes.location.Province
import com.onestopcoding.forum.repositories.LocationRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class LocationService(private val locationRepository: LocationRepository) {
    fun save(location: Location): Location {
        return locationRepository.save(location)
    }

    fun saveAll(locations: List<Location>): List<Location> {
        return locationRepository.saveAll(locations)
    }

    fun getAll(): List<Location> {
        return locationRepository.findAll()
    }

    fun getLocationByCity(city: String): List<Location> {
        return locationRepository.getLocationsByCity_Name(city)
    }

    fun getLocationByCountry(country: String): List<Location> {
        return locationRepository.getLocationsByCountry_Name(country)
    }

    fun getLocationsByProvence(provence: String): List<Location> {
        return locationRepository.getLocationsByProvince_Name(provence)
    }

    fun getProvincesByCountry(country: String): List<Province> {
        val locations = getLocationByCountry(country)
        return getProvArray(locations)
    }

    private fun getProvArray(locations: List<Location>): List<Province> {
        val provinces: ArrayList<Province> = ArrayList(mutableListOf())
        for (location in locations) {
            if (!provinces.contains(location.province))
                provinces.add(location.province)
        }
        return provinces
    }

    fun getCitiesByProvince(provence: String): List<City> {
        val locations = getLocationsByProvence(provence)
       return getCitiesArray(locations)
    }

    private fun getCitiesArray(locations: List<Location>):List<City>{
        val cities: ArrayList<City> = ArrayList(mutableListOf())
        for (location in locations) {
            cities.add(location.city)
        }
        return cities
    }

    fun allProvinces(): List<Province> {
        val locations = getAll()
        return getProvArray(locations)
    }

    fun allCities():List<City>{
        val locations = getAll()
        return getCitiesArray(locations)
    }
    fun getLocationByCityInCountry(city: String, country: String):Location{
        return locationRepository.getLocationByCountry_NameAndCity_Name(country, city)[0]
    }

    /*   @PostConstruct
       fun createNlLocations() {
           locationRepository.saveAll(
               listOf(
                   Location(UUID.randomUUID(), City("Alkmaar"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Amsterdam"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Medemblik"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Haarlem"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Hoorn"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Zaandam"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Hilversum"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Amstelveen"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Boekel"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Enkhuizen"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Heerhugowaard"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Schagen"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Zaanse Schans"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Volendam"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Hoofddorp"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Waterland"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Purmerend"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Texel"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Kreil"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Callantsoog"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Gouwé"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Zandvoort"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Noordburen"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Naarden"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Bergen"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Den Helder"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Zaanstad"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Koggenland"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Velsen"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Laren"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Marken"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Uitgeest"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Beemster"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Diemen"), Province("Noord-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Middelburg"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Goes"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Zierikzee"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Vlissingen"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Domburg"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Zoutelande"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Sluis"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Renesse"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Aardenburg"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Arnemuiden"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Veere"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Groede"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Burgh Haamstede"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Cadzand"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Yerseke"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Terneuzen"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Schouwen-Duiveland"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Hoek"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Noord-Beverland"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Breskens"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Tholen"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Hulst"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Oostkapelle"), Province("Zeeland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Rotterdam"), Province("Zuid-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Leiden"), Province("Zuid-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Den Haag"), Province("Zuid-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Zoetermeer"), Province("Zuid-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Dordrecht"), Province("Zuid-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Westland"), Province("Zuid-Holland"), Country("Nederland")),
                   Location(
                       UUID.randomUUID(),
                       City("Alphen aan den Rijn"),
                       Province("Zuid-Holland"),
                       Country("Nederland")
                   ),
                   Location(UUID.randomUUID(), City("Delft"), Province("Zuid-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Hoeksche Waard"), Province("Zuid-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Nissewaard"), Province("Zuid-Holland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Utrechtse Heuvelrug"), Province("Utrecht"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Houten"), Province("Utrecht"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Woerden"), Province("Utrecht"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Vijfheerlanden"), Province("Utrecht"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Nieuwegein"), Province("Utrecht"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Stchtse Vecht"), Province("Utrecht"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Zeist"), Province("Utrecht"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Veenendaal"), Province("Utrecht"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Amersfoort"), Province("Utrecht"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Utrecht"), Province("Utrecht"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Virton"), Province("Utrecht"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Almere"), Province("Flevoland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Lelystad"), Province("Flvoland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Noordoostpolder"), Province("Flevoland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Zeewolde"), Province("Flevoland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Dronten"), Province("Flevoland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Urk"), Province("Flevoland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Eindhoven"), Province("Noord-Brabant"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Tilburg"), Province("Noord-Brabant"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Breda"), Province("Noord-Brabant"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Den Bosch"), Province("Noord-Brabant"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Hellmond"), Province("Noord-Brabant"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Oss"), Province("Noord-Brabant"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Land van Cuijk"), Province("Noord-Brabant"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Mijerstad"), Province("Noord-Brabant"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Roosendaal"), Province("Noord-Brabant"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Bergen op Zoom"), Province("Noord-Brabant"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Maastricht"), Province("Limburg"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Venlo"), Province("Limburg"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Sittard-Geleen"), Province("Limburg"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Heerlen"), Province("Limburg"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Roermond"), Province("Limburg"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Weert"), Province("Limburg"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Kerktrade"), Province("Limburg"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Peel en Maas"), Province("Limburg"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Nijmegem"), Province("Gelderland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Apeldoorn"), Province("Gelderland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Arnhem"), Province("Gelderland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Ede"), Province("Gelderland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Barneveld"), Province("Gelderland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Doetinchem"), Province("Gelderland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("West Betuwe"), Province("Gelderland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Harderwijk"), Province("Gelderland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Overbetuwe"), Province("Gelderland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Zutphen"), Province("Gelderland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Enschede"), Province("Overijsel"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Zwolle"), Province("Overijsel"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Deventer"), Province("Overijsel"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Hengelo"), Province("Overijsel"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Almelo"), Province("Overijsel"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Hardenberg"), Province("Overijsel"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Kampen"), Province("Overijsel"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Steenwijkerland"), Province("Overijsel"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Emmen"), Province("Drenthe"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Assen"), Province("Drenthe"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Hoogeveen"), Province("Drenthe"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Coevorden"), Province("Drenthe"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Meppel"), Province("Drenthe"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Leeuwarden"), Province("Friesland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Südwest-Fryslän"), Province("Friesland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Smallingerland"), Province("Friesland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("De Fryske Marren"), Province("Friesland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Heerenveen"), Province("Friesland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Waadhoeke"), Province("Friesland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Noardeast-Fryslän"), Province("Friesland"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Groningen"), Province("Groningen"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Westerkwartier"), Province("Groningen"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Midden-Groningen"), Province("Groningen"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Het Hogeland"), Province("Groningen"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Eemsdelta"), Province("Groningen"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Oldambt"), Province("Groningen"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Stadskanaal"), Province("Groningen"), Country("Nederland")),
                   Location(UUID.randomUUID(), City("Veendam"), Province("Groningen"), Country("Nederland")),
               )
           )
       }

       @PostConstruct
       fun createLuxLocations() {
           locationRepository.saveAll(
               listOf(
                   Location(UUID.randomUUID(), City("Clerveaux"), Province("Clearveaux"), Country("Luxembourg")),
                   Location(UUID.randomUUID(), City("Echternach"), Province("Echternach"), Country("Luxembourg")),
                   Location(UUID.randomUUID(), City("Luxembourg"), Province("Luxembourg"), Country("Luxembourg")),
                   Location(UUID.randomUUID(), City("Remich"), Province("Remich"), Country("Luxembourg")),
                   Location(UUID.randomUUID(), City("Grevenmacher"), Province("Grevenmacher"), Country("Luxembourg")),
                   Location(
                       UUID.randomUUID(),
                       City("Esch-sur-Alzette"),
                       Province("Esch-sur-Alzette"),
                       Country("Luxembourg")
                   ),
                   Location(UUID.randomUUID(), City("Capellen"), Province("Capellen"), Country("Luxembourg")),
                   Location(UUID.randomUUID(), City("Redange"), Province("Redange"), Country("Luxembourg")),
                   Location(UUID.randomUUID(), City("Mersch"), Province("Mersch"), Country("Luxembourg")),
                   Location(UUID.randomUUID(), City("Vianden"), Province("Vianden"), Country("Luxembourg")),
                   Location(UUID.randomUUID(), City("Diekirch"), Province("Diekirch"), Country("Luxembourg")),
                   Location(UUID.randomUUID(), City("Wiltz"), Province("Wiltz"), Country("Luxembourg")),
               )
           )
       }

       @PostConstruct
       fun createBelgiumLocations() {
           locationRepository.saveAll(
               listOf(
                   Location(UUID.randomUUID(), City("Brussel"), Province("Brussel-Hoofdstad"), Country("België")),
                   Location(UUID.randomUUID(), City("Antwerpen"), Province("Antwerpen"), Country("België")),
                   Location(UUID.randomUUID(), City("Geel"), Province("Antwerpen"), Country("België")),
                   Location(UUID.randomUUID(), City("Herentals"), Province("Antwerpen"), Country("België")),
                   Location(UUID.randomUUID(), City("Hoogstraten"), Province("Antwerpen"), Country("België")),
                   Location(UUID.randomUUID(), City("Lier"), Province("Antwerpen"), Country("België")),
                   Location(UUID.randomUUID(), City("Mechelen"), Province("Antwerpen"), Country("België")),
                   Location(UUID.randomUUID(), City("Mortsel"), Province("Antwerpen"), Country("België")),
                   Location(UUID.randomUUID(), City("Turnhout"), Province("Antwerpen"), Country("België")),
                   Location(UUID.randomUUID(), City("Aat"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Antoing"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Beaumont"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Bergen"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Binche"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Charleroi"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Châtelet"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Chièvres"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Chimay"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Doornik"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Edingen"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Fleurus"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Fontaine-l\'Evêque"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("\'s-Gravenbrakel"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Komen-Waasten"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("La Louvière"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Le Rœulx"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Lessen"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Leuze-en-Hainaut"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Moeskroen"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Péruwelz"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Saint-Ghislain"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Thuin"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Zinnik"), Province("Henegouwen"), Country("België")),
                   Location(UUID.randomUUID(), City("Beringen"), Province("Limburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Bilzen"), Province("Limburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Borgloon"), Province("Limburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Bree"), Province("Limburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Dilsen-Stokkem"), Province("Limburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Genk"), Province("Limburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Halen"), Province("Limburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Hamont-Achel"), Province("Limburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Hasselt"), Province("Limburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Herk-de-Stad"), Province("Limburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Lommel"), Province("Limburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Maaseik"), Province("Limburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Peer"), Province("Limburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Sint-Truiden"), Province("Limburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Tongeren"), Province("Limburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Ans"), Province("Luik"), Country("België")),
                   Location(UUID.randomUUID(), City("Borgworm"), Province("Luik"), Country("België")),
                   Location(UUID.randomUUID(), City("Eupen"), Province("Luik"), Country("België")),
                   Location(UUID.randomUUID(), City("Hannuit"), Province("Luik"), Country("België")),
                   Location(UUID.randomUUID(), City("Herstal"), Province("Luik"), Country("België")),
                   Location(UUID.randomUUID(), City("Herve"), Province("Luik"), Country("België")),
                   Location(UUID.randomUUID(), City("Hoei"), Province("Luik"), Country("België")),
                   Location(UUID.randomUUID(), City("Limburg"), Province("Luik"), Country("België")),
                   Location(UUID.randomUUID(), City("Luik"), Province("Luik"), Country("België")),
                   Location(UUID.randomUUID(), City("Malmedy"), Province("Luik"), Country("België")),
                   Location(UUID.randomUUID(), City("Sankt Vith"), Province("Luik"), Country("België")),
                   Location(UUID.randomUUID(), City("Seraing"), Province("Luik"), Country("België")),
                   Location(UUID.randomUUID(), City("Spa"), Province("Luik"), Country("België")),
                   Location(UUID.randomUUID(), City("Stavelot"), Province("Luik"), Country("België")),
                   Location(UUID.randomUUID(), City("Verviers"), Province("Luik"), Country("België")),
                   Location(UUID.randomUUID(), City("Wezet"), Province("Luik"), Country("België")),
                   Location(UUID.randomUUID(), City("Aarlen"), Province("Luxemburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Aubange"), Province("Luxemburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Bastenaken"), Province("Luxemburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Bouillon"), Province("Luxemburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Chiny"), Province("Luxemburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Durbuy"), Province("Luxemburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Florenville"), Province("Luxemburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Houffalize"), Province("Luxemburg"), Country("België")),
                   Location(UUID.randomUUID(), City("La Roche-en-Ardenne"), Province("Luxemburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Marche-en-Famenne"), Province("Luxemburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Neufchâteau"), Province("Luxemburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Saint-Hubert"), Province("Luxemburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Virton"), Province("Luxemburg"), Country("België")),
                   Location(UUID.randomUUID(), City("Andenne"), Province("Namen"), Country("België")),
                   Location(UUID.randomUUID(), City("Beauraing"), Province("Namen"), Country("België")),
                   Location(UUID.randomUUID(), City("Ciney"), Province("Namen"), Country("België")),
                   Location(UUID.randomUUID(), City("Couvin"), Province("Namen"), Country("België")),
                   Location(UUID.randomUUID(), City("Dinant"), Province("Namen"), Country("België")),
                   Location(UUID.randomUUID(), City("Fosses-la-Ville"), Province("Namen"), Country("België")),
                   Location(UUID.randomUUID(), City("Gembloers"), Province("Namen"), Country("België")),
                   Location(UUID.randomUUID(), City("Namen"), Province("Namen"), Country("België")),
                   Location(UUID.randomUUID(), City("Philippeville"), Province("Namen"), Country("België")),
                   Location(UUID.randomUUID(), City("Rochefort"), Province("Namen"), Country("België")),
                   Location(UUID.randomUUID(), City("Walcourt"), Province("Namen"), Country("België")),
                   Location(UUID.randomUUID(), City("Aalst"), Province("Oost-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Deinze"), Province("Oost-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Dendermonde"), Province("Oost-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Eeklo"), Province("Oost-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Gent"), Province("Oost-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Geraardsbergen"), Province("Oost-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Lokeren"), Province("Oost-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Ninove"), Province("Oost-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Oudenaarde"), Province("Oost-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Ronse"), Province("Oost-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Sint-Niklaas"), Province("Oost-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Zottegem"), Province("Oost-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Aarschot"), Province("Vlaams-Brabant"), Country("België")),
                   Location(UUID.randomUUID(), City("Diest"), Province("Vlaams-Brabant"), Country("België")),
                   Location(UUID.randomUUID(), City("Halle"), Province("Vlaams-Brabant"), Country("België")),
                   Location(UUID.randomUUID(), City("Landen"), Province("Vlaams-Brabant"), Country("België")),
                   Location(UUID.randomUUID(), City("Leuven"), Province("Vlaams-Brabant"), Country("België")),
                   Location(
                       UUID.randomUUID(),
                       City("Scherpenheuvel-Zichem"),
                       Province("Vlaams-Brabant"),
                       Country("België")
                   ),
                   Location(UUID.randomUUID(), City("Tienen"), Province("Vlaams-Brabant"), Country("België")),
                   Location(UUID.randomUUID(), City("Vilvoorde"), Province("Vlaams-Brabant"), Country("België")),
                   Location(UUID.randomUUID(), City("Zoutleeuw"), Province("Vlaams-Brabant"), Country("België")),
                   Location(UUID.randomUUID(), City("Geldenaken"), Province("Waals-Brabant"), Country("België")),
                   Location(UUID.randomUUID(), City("Genepiën"), Province("Waals-Brabant"), Country("België")),
                   Location(UUID.randomUUID(), City("Nijvel"), Province("Waals-Brabant"), Country("België")),
                   Location(
                       UUID.randomUUID(),
                       City("Ottignies-Louvain-la-Neuve"),
                       Province("Waals-Brabant"),
                       Country("België")
                   ),
                   Location(UUID.randomUUID(), City("Tubeke"), Province("Waals-Brabant"), Country("België")),
                   Location(UUID.randomUUID(), City("Waver"), Province("Waals-Brabant"), Country("België")),
                   Location(UUID.randomUUID(), City("Blankenberge"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Brugge"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Damme"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Diksmuide"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Gistel"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Harelbeke"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Ieper"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Izegem"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Kortrijk"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Lo-Reninge"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Menen"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Mesen"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Nieuwpoort"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Oostende"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Oudenburg"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Poperinge"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Roeselare"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Tielt"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Torhout"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Veurne"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Waregem"), Province("West-Vlaanderen"), Country("België")),
                   Location(UUID.randomUUID(), City("Wervik"), Province("West-Vlaanderen"), Country("België"))
               )
           )
       }*/
}