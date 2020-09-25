package ru.modelov.testapp65apps.listspecialties.presentation.uistate

sealed class SpecialtiesUiState {
    object Success : SpecialtiesUiState()
    object Loading : SpecialtiesUiState()
    data class Error(val message: String?) : SpecialtiesUiState()
}