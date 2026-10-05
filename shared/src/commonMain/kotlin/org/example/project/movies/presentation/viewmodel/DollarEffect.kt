package org.example.project.movies.presentation.viewmodel

interface DollarEffect {
    data class ShowToast(
        val message: String
    ) : DollarEffect
}