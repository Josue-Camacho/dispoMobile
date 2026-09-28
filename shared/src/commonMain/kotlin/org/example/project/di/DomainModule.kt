package org.example.project.di

import org.example.project.earthquakes.domain.usecase.EarthquakeUseCase
import org.example.project.movies.domain.repository.CatalogRepository
import org.example.project.movies.domain.usecase.GetCatalogUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {

    factory {
        GetCatalogUseCase(
            repository = get<CatalogRepository>()
        )
    }

    singleOf(::EarthquakeUseCase)
}