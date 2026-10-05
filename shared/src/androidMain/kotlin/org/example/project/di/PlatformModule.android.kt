package org.example.project.di

import org.example.project.config.AppDatabase
import org.example.project.config.getDatabaseBuilder
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {

    single<AppDatabase> {
        getDatabaseBuilder(get()).build()
    }
}