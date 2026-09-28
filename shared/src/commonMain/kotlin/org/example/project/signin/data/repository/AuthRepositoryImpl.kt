package org.example.project.signin.data.repository

import org.example.project.signin.domain.model.User
import org.example.project.signin.domain.repository.AuthRepository
import org.example.project.signin.domain.vo.Password
import org.example.project.signin.domain.vo.Username

class AuthRepositoryImpl : AuthRepository {

    override fun login(
        username: Username,
        password: Password
    ): User? {

        // Login simulado por ahora
        return User(
            username = username.value
        )
    }
}