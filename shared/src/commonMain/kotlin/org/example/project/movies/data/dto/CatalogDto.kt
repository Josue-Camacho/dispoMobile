package org.example.project.movies.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CatalogDto(
    val page: Int,
    val results: List<MovieDto>
)