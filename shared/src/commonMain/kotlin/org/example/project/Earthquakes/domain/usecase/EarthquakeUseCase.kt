package org.example.project.earthquakes.domain.usecase

import org.example.project.earthquakes.domain.model.EarthquakeModel
import org.example.project.earthquakes.domain.repository.EarthquakeRepository

class EarthquakeUseCase(
    private val repository: EarthquakeRepository
) {

    suspend operator fun invoke(): Result<List<EarthquakeModel>> {
        return repository.getEarthquakes()
    }
}