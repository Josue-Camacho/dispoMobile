package org.example.project.di

import org.example.project.earthquakes.presentation.viewmodel.EarthquakeViewModel
import org.example.project.movies.presentation.viewmodel.CatalogViewModel
import org.example.project.movies.presentation.viewmodel.DollarViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.example.project.exchange.presentation.viewmodel.ExchangeViewModel
val presentationModule = module {

    viewModelOf(::CatalogViewModel)

    viewModelOf(::EarthquakeViewModel)

    viewModelOf(::DollarViewModel)
    viewModelOf(::ExchangeViewModel)
}