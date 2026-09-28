package org.example.project.di

import org.example.project.profile.data.datasource.GithubRemoteDataSource
import org.example.project.profile.data.repository.GithubRepositoryImpl
import org.example.project.profile.data.service.GitHubApiService
import org.example.project.profile.domain.repository.GithubRepository

import org.example.project.movies.data.datasource.CatalogRemoteDataSource
import org.example.project.movies.data.repository.CatalogRepositoryImpl
import org.example.project.movies.data.service.CatalogService
import org.example.project.movies.domain.repository.CatalogRepository

import org.example.project.earthquakes.data.datasource.EarthquakeRemoteDataSource
import org.example.project.earthquakes.data.repository.EarthquakeRepositoryImpl
import org.example.project.earthquakes.data.service.EarthquakeService
import org.example.project.earthquakes.domain.repository.EarthquakeRepository

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

    single<EarthquakeRemoteDataSource> {
        EarthquakeService()
    }

    single<EarthquakeRepository> {
        EarthquakeRepositoryImpl(get())
    }
}