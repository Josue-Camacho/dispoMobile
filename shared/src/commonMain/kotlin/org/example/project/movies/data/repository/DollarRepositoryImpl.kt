package org.example.project.movies.data.repository

import org.example.project.movies.data.datasource.DollarLocalDataSource
import org.example.project.movies.domain.model.DollarModel
import org.example.project.movies.domain.repository.DollarRepository

class DollarRepositoryImpl(
    val localDataSource: DollarLocalDataSource
) : DollarRepository {

    override suspend fun getList(): List<DollarModel> {
        return localDataSource.getList()
    }

    override suspend fun insert(dollar: DollarModel) {
        localDataSource.insert(dollar)
    }
}