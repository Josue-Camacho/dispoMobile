package org.example.project.profile.data.datasource

import org.example.project.profile.data.dto.UserInfoDto

interface GithubRemoteDataSource {

    suspend fun getUser(
        nickname: String
    ): UserInfoDto
}