package org.example.project.exchange.data.repository

import kotlinx.coroutines.flow.Flow
import org.example.project.exchange.data.datasource.RealTimeDataBase
import org.example.project.exchange.domain.repository.ExchangeRepository

class ExchangeRepositoryImpl(
    val realTimeDataBase: RealTimeDataBase
) : ExchangeRepository {

    override suspend fun observe(): Flow<String?> {
        return realTimeDataBase.observeMessage()
    }
}