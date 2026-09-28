package org.example.project.profile.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserInfoDto(
    val email: String? = null,

    @SerialName("avatar_url")
    val avatarUrl: String? = null,
)