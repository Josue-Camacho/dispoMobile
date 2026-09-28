package org.example.project.movies.data.mapper

import org.example.project.movies.data.dto.MovieDto
import org.example.project.movies.domain.model.MovieModel

fun MovieDto.toModel(): MovieModel {
    return MovieModel(
        title = title,
        posterPath = posterPath
    )
}