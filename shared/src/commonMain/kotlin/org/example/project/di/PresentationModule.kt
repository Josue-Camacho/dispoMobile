package org.example.project.di

import org.example.project.movies.presentation.viewmodel.CatalogViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

import org.example.project.earthquakes.presentation.viewmodel.EarthquakeViewModel
val presentationModule = module {

    viewModelOf(::EarthquakeViewModel)



}