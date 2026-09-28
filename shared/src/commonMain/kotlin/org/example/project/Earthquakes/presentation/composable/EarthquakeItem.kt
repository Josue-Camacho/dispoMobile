package org.example.project.earthquakes.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.earthquakes.domain.model.EarthquakeModel

@Composable
fun EarthquakeItem(
    earthquake: EarthquakeModel
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "Ubicación: ${earthquake.place}"
            )

            Text(
                text = "Magnitud: ${earthquake.magnitude}"
            )

            Text(
                text = "Fecha y hora: ${earthquake.time}"
            )

            Text(
                text = "Enlace: ${earthquake.url}"
            )

            Text(
                text = "Longitud: ${earthquake.longitude}"
            )

            Text(
                text = "Latitud: ${earthquake.latitude}"
            )

            Text(
                text = "Profundidad: ${earthquake.depth}"
            )
        }
    }
}