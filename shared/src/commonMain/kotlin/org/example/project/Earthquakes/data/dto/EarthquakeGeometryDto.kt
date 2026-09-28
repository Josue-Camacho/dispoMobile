package org.example.project.earthquakes.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class EarthquakeGeometryDto(
    val coordinates: List<Double> = emptyList()
)