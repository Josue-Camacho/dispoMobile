package org.example.project.di

import org.example.project.profile.data.datasource.GithubRemoteDataSource
import org.example.project.profile.data.repository.GithubRepositoryImpl
import org.example.project.profile.data.service.GitHubApiService
import org.example.project.profile.domain.repository.GithubRepository

import org.example.project.movies.data.datasource.CatalogRemoteDataSource
import org.example.project.movies.data.repository.CatalogRepositoryImpl
import org.example.project.movies.data.service.CatalogService
import org.example.project.movies.domain.repository.CatalogRepository
<<<<<<< HEAD

import org.example.project.earthquakes.data.datasource.EarthquakeRemoteDataSource
import org.example.project.earthquakes.data.repository.EarthquakeRepositoryImpl
import org.example.project.earthquakes.data.service.EarthquakeService
import org.example.project.earthquakes.domain.repository.EarthquakeRepository

=======
import org.example.project.config.AppDatabase
import org.example.project.movies.data.dao.DollarDao
import org.example.project.movies.data.datasource.DollarLocalDataSource
import org.example.project.movies.data.repository.DollarRepositoryImpl
import org.example.project.movies.domain.repository.DollarRepository
import org.koin.core.module.dsl.singleOf
>>>>>>> a74076a (Firebase and cambios de bd)
import org.koin.dsl.module

val dataModule = module {

    single<GithubRemoteDataSource> {
        GitHubApiService()
    }

    single<GithubRepository> {
        GithubRepositoryImpl(get())
    }

    single<CatalogRemoteDataSource> {
        CatalogService()
    }

    single<CatalogRepository> {
        CatalogRepositoryImpl(get())
    }

<<<<<<< HEAD
    single<EarthquakeRemoteDataSource> {
        EarthquakeService()
    }

    single<EarthquakeRepository> {
        EarthquakeRepositoryImpl(get())
=======
    single<DollarDao> {
        get<AppDatabase>().getDao()
    }

    singleOf(::DollarLocalDataSource)

    single<DollarRepository> {
        DollarRepositoryImpl(get())
>>>>>>> a74076a (Firebase and cambios de bd)
    }
}