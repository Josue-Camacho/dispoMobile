package org.example.project.earthquakes.presentation.viewmodel

sealed interface EarthquakeEvent {

    data object OnRetry : EarthquakeEvent
}