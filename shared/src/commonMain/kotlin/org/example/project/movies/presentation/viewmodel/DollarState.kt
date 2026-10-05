package org.example.project.movies.presentation.viewmodel

import org.example.project.movies.domain.model.DollarModel

data class DollarState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val list: List<DollarModel> = emptyList()
)