package org.example.project.earthquakes.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.earthquakes.presentation.viewmodel.EarthquakeEffect
import org.example.project.earthquakes.presentation.viewmodel.EarthquakeEvent
import org.example.project.earthquakes.presentation.viewmodel.EarthquakeViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.example.project.earthquakes.presentation.composable.EarthquakeItem
@Composable
fun EarthquakeScreen(
    viewModel: EarthquakeViewModel = koinViewModel()
) {

    val state = viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.effects.collect { effect ->
            when (effect) {
                is EarthquakeEffect.ShowToast -> {
                    println("ERROR ${effect.message}")
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("USGS Earthquakes")

        if (state.value.isLoading) {
            CircularProgressIndicator()
        }

        state.value.error?.let { error ->
            Text(error)

            Button(
                onClick = {
                    viewModel.emitEvent(
                        EarthquakeEvent.OnRetry
                    )
                }
            ) {
                Text("REINTENTAR")
            }
        }

        state.value.list.forEach { earthquake ->

            EarthquakeItem(
                earthquake = earthquake
            )
        }
    }
}