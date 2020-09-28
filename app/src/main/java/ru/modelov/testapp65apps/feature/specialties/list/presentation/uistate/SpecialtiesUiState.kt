package ru.modelov.testapp65apps.feature.specialties.list.presentation.uistate

sealed class SpecialtiesUiState {
    object Success : SpecialtiesUiState()
    object Loading : SpecialtiesUiState()
    data class Error(val message: String?) : SpecialtiesUiState()
}