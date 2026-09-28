package org.example.project.profile.domain.repository

import org.example.project.profile.domain.model.UserInfoModel

interface GithubRepository {

    suspend fun findByAlias(
        alias: String
    ): Result<UserInfoModel>
}