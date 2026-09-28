package org.example.project.movies.data.repository

import org.example.project.movies.data.datasource.CatalogRemoteDataSource
import org.example.project.movies.domain.model.MovieModel
import org.example.project.movies.domain.repository.CatalogRepository

class CatalogRepositoryImpl(
    private val dataSource: CatalogRemoteDataSource
) : CatalogRepository {

    override suspend fun getMovies(): Result<List<MovieModel>> {
        return dataSource.fetchData()
    }
}