package org.example.project.earthquakes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.example.project.earthquakes.domain.usecase.EarthquakeUseCase

class EarthquakeViewModel(
    private val useCase: EarthquakeUseCase
) : ViewModel() {

    private val _effects = MutableSharedFlow<EarthquakeEffect>()
    val effects = _effects.asSharedFlow()

    private val _state = MutableStateFlow(EarthquakeState())
    val state = _state.asStateFlow()

    init {
        loadEarthquakes()
    }

    private fun emitEffect(effect: EarthquakeEffect) {
        viewModelScope.launch {
            _effects.emit(effect)
        }
    }

    fun emitEvent(event: EarthquakeEvent) {
        when (event) {
            EarthquakeEvent.OnRetry -> {
                loadEarthquakes()
            }
        }
    }

    private fun loadEarthquakes() {

        viewModelScope.launch {

            _state.value = _state.value.copy(
                isLoading = true,
                error = null
            )

            useCase()
                .onSuccess { earthquakes ->

                    _state.value = _state.value.copy(
                        isLoading = false,
                        list = earthquakes
                    )
                }
                .onFailure { error ->

                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = error.message
                    )

                    emitEffect(
                        EarthquakeEffect.ShowToast(
                            error.message ?: "Error al obtener terremotos"
                        )
                    )
                }
        }
    }
}