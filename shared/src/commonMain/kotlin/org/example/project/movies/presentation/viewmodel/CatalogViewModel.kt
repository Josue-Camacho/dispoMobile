package org.example.project.movies.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.example.project.movies.domain.model.MovieModel
import org.example.project.movies.domain.usecase.GetCatalogUseCase

class CatalogViewModel(
    private val getCatalogUseCase: GetCatalogUseCase
) : ViewModel() {

    var movies by mutableStateOf<List<MovieModel>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    fun loadMovies() {

        viewModelScope.launch {

            isLoading = true
            error = null

            getCatalogUseCase()
                .onSuccess { result ->
                    movies = result
                }
                .onFailure { exception ->
                    error = exception.message ?: "Error al cargar películas"
                }

            isLoading = false
        }
    }
}