package org.example.project.earthquakes.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class EarthquakeFeatureDto(
    val properties: EarthquakePropertiesDto,
    val geometry: EarthquakeGeometryDto
)