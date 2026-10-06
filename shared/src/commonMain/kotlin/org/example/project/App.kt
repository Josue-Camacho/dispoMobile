package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.example.project.exchange.presentation.screen.ExchangeScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        ExchangeScreen()
    }
}