package org.example.project.earthquakes.data.repository

import org.example.project.earthquakes.data.datasource.EarthquakeRemoteDataSource
import org.example.project.earthquakes.domain.model.EarthquakeModel
import org.example.project.earthquakes.domain.repository.EarthquakeRepository

class EarthquakeRepositoryImpl(
    private val dataSource: EarthquakeRemoteDataSource
) : EarthquakeRepository {

    override suspend fun getEarthquakes(): Result<List<EarthquakeModel>> {
        return dataSource.fetchData()
    }
}