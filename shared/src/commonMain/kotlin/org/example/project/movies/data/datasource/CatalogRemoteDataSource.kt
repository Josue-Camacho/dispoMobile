package org.example.project.movies.data.datasource


import org.example.project.movies.domain.model.MovieModel

interface CatalogRemoteDataSource {

    suspend fun fetchData(): Result<List<MovieModel>>
}