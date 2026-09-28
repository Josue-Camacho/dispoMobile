package org.example.project.earthquakes.data.datasource

import org.example.project.earthquakes.domain.model.EarthquakeModel

interface EarthquakeRemoteDataSource {

    suspend fun fetchData(): Result<List<EarthquakeModel>>
}