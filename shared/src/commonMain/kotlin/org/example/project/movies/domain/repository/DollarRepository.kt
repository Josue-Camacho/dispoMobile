package org.example.project.movies.domain.repository

import org.example.project.movies.domain.model.DollarModel

interface DollarRepository {

    suspend fun getList(): List<DollarModel>

    suspend fun insert(dollar: DollarModel)
}