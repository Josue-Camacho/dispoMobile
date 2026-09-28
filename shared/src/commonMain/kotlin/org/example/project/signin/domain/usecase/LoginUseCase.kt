package org.example.project.signin.domain.usecase

import org.example.project.signin.domain.model.User
import org.example.project.signin.domain.repository.AuthRepository
import org.example.project.signin.domain.vo.Password
import org.example.project.signin.domain.vo.Username

class LoginUseCase(
    private val repository: AuthRepository
) {

    operator fun invoke(
        username: String,
        password: String
    ): User? {

        if (username.isBlank() || password.isBlank()) {
            return null
        }

        return repository.login(
            username = Username(username),
            password = Password(password)
        )
    }
}