package org.example.project.profile.data.mapper

import org.example.project.profile.data.dto.UserInfoDto
import org.example.project.profile.domain.model.UserInfoModel

fun UserInfoDto.toDomain(): UserInfoModel = UserInfoModel(
    email = email ?: "",
    company = "",
    avatarUrl = avatarUrl ?: "",
    alias = ""
)