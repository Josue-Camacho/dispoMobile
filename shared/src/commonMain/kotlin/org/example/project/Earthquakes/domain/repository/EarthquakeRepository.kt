package org.example.project.earthquakes.domain.repository

import org.example.project.earthquakes.domain.model.EarthquakeModel

interface EarthquakeRepository {

    suspend fun getEarthquakes(): Result<List<EarthquakeModel>>
}