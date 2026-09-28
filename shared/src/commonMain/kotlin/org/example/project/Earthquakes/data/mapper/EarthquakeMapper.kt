package org.example.project.earthquakes.data.mapper

import org.example.project.earthquakes.data.dto.EarthquakeFeatureDto
import org.example.project.earthquakes.domain.model.EarthquakeModel

fun EarthquakeFeatureDto.toModel(): EarthquakeModel {
    return EarthquakeModel(
        place = properties.place ?: "",
        magnitude = properties.mag ?: 0.0,
        time = properties.time ?: 0L,
        url = properties.url ?: "",
        longitude = geometry.coordinates.getOrNull(0) ?: 0.0,
        latitude = geometry.coordinates.getOrNull(1) ?: 0.0,
        depth = geometry.coordinates.getOrNull(2) ?: 0.0
    )
}