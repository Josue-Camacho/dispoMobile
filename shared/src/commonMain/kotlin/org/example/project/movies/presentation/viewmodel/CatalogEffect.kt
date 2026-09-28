package org.example.project.movies.presentation.viewmodel

sealed interface CatalogEffect {

    data class ShowError(
        val message: String
    ) : CatalogEffect
}