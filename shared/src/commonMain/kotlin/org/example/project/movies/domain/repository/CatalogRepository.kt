package org.example.project.movies.domain.repository

import org.example.project.movies.domain.model.MovieModel

interface CatalogRepository {
    suspend fun getMovies(): Result<List<MovieModel>>
}