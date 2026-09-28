package org.example.project.movies.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.movies.domain.model.MovieModel

@Composable
fun MovieItem(
    movie: MovieModel
) {
    Card {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = movie.title
            )

            Text(
                text = movie.posterPath
            )
        }
    }
}