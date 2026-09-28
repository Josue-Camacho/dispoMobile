package org.example.project.earthquakes.presentation.viewmodel

sealed interface EarthquakeEffect {

    data class ShowToast(
        val message: String
    ) : EarthquakeEffect
}