package org.example.project.signin.presentation.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.example.project.signin.data.repository.AuthRepositoryImpl
import org.example.project.signin.domain.usecase.LoginUseCase

class LoginViewModel {

    private val repository = AuthRepositoryImpl()

    private val loginUseCase = LoginUseCase(
        repository = repository
    )

    var state by mutableStateOf(LoginState())
        private set

    var effect by mutableStateOf<LoginEffect?>(null)
        private set

    fun onEvent(event: LoginEvent) {

        when (event) {

            is LoginEvent.UsernameChanged -> {
                state = state.copy(
                    username = event.username
                )
            }

            is LoginEvent.PasswordChanged -> {
                state = state.copy(
                    password = event.password
                )
            }

            LoginEvent.LoginClicked -> {
                login()
            }
            LoginEvent.ProfileClicked -> {
                effect = LoginEffect.NavigateToProfile
            }
        }
    }

    private fun login() {

        if (
            state.username.isBlank() ||
            state.password.isBlank()
        ) {
            effect = LoginEffect.ShowError(
                "Complete todos los campos"
            )

            return
        }

        state = state.copy(
            isLoading = true,
            errorMessage = null
        )

        val user = loginUseCase(
            username = state.username,
            password = state.password
        )

        state = state.copy(
            isLoading = false
        )

        if (user != null) {
            effect = LoginEffect.NavigateToMovies
        } else {
            effect = LoginEffect.ShowError(
                "Usuario o contraseña incorrectos"
            )
        }
    }

    fun clearEffect() {
        effect = null
    }
}