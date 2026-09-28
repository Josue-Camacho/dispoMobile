package org.example.project.signin.presentation.state

sealed interface LoginEffect {

    data object NavigateToMovies : LoginEffect

    data object NavigateToProfile : LoginEffect

    data class ShowError(
        val message: String
    ) : LoginEffect
}
