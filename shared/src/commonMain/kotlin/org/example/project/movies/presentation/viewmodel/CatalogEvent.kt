package org.example.project.movies.presentation.viewmodel

sealed interface CatalogEvent {

    data object LoadMovies : CatalogEvent
}