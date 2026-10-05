package org.example.project.di

import org.koin.core.module.Module

fun sharedModules(): List<Module> = listOf(
    platformModule(),
    dataModule,
    presentationModule,
    domainModule
)