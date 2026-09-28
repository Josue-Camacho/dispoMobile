package org.example.project.earthquakes.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class EarthquakeDto(
    val features: List<EarthquakeFeatureDto> = emptyList()
)