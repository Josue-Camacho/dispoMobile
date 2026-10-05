package org.example.project.movies.presentation.viewmodel

sealed interface DollarEvent {
    object OnAddRecord : DollarEvent
}