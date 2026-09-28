package org.example.project.movies.domain.usecase

import org.example.project.movies.domain.model.MovieModel
import org.example.project.movies.domain.repository.CatalogRepository

class GetCatalogUseCase(
    private val repository: CatalogRepository
) {

    suspend operator fun invoke(): Result<List<MovieModel>> {
        return repository.getMovies()
    }
}