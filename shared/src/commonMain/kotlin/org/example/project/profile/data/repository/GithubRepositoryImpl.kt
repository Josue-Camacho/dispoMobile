package org.example.project.profile.data.repository

import org.example.project.profile.data.datasource.GithubRemoteDataSource
import org.example.project.profile.data.mapper.toDomain
import org.example.project.profile.domain.model.UserInfoModel
import org.example.project.profile.domain.repository.GithubRepository

class GithubRepositoryImpl(
    val dataSource: GithubRemoteDataSource
) : GithubRepository {

    override suspend fun findByAlias(
        alias: String
    ): Result<UserInfoModel> {
        return Result.success(
            dataSource.getUser(alias).toDomain()
        )
    }
}