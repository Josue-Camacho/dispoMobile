package org.example.project.signin.domain.repository

import org.example.project.signin.domain.model.User
import org.example.project.signin.domain.vo.Password
import org.example.project.signin.domain.vo.Username

interface AuthRepository {

    fun login(
        username: Username,
        password: Password
    ): User?
}