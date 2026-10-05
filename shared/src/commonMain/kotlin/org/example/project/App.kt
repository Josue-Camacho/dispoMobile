package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.project.movies.presentation.screen.DollarScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        DollarScreen()
    }
}