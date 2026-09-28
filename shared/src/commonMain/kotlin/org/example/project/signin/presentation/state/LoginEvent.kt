package org.example.project.signin.presentation.state

sealed interface LoginEvent {

    data class UsernameChanged(
        val username: String
    ) : LoginEvent

    data class PasswordChanged(
        val password: String
    ) : LoginEvent

    data object LoginClicked : LoginEvent
    data object ProfileClicked : LoginEvent
}