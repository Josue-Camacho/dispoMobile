package org.example.project.earthquakes.presentation.viewmodel

import org.example.project.earthquakes.domain.model.EarthquakeModel

data class EarthquakeState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val list: List<EarthquakeModel> = emptyList()
)