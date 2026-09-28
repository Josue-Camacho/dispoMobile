package org.example.project.movies.presentation.viewmodel

import org.example.project.movies.domain.model.MovieModel

data class CatalogState(
    val movies: List<MovieModel> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)