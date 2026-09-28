package org.example.project.earthquakes.data.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.project.earthquakes.data.datasource.EarthquakeRemoteDataSource
import org.example.project.earthquakes.data.dto.EarthquakeDto
import org.example.project.earthquakes.data.mapper.toModel
import org.example.project.earthquakes.domain.model.EarthquakeModel

class EarthquakeService : EarthquakeRemoteDataSource {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    override suspend fun fetchData(): Result<List<EarthquakeModel>> {

        return try {

            val response = client.get(
                "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&minmagnitude=5&limit=3"
            )

            val earthquakeDto = response.body<EarthquakeDto>()

            Result.success(
                earthquakeDto.features.map {
                    it.toModel()
                }
            )

        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}