package ru.modelov.testapp65apps.listemployees.presentation.uistate

sealed class EmployeesUiState {
    object Success : EmployeesUiState()
    object Loading : EmployeesUiState()
    data class Error(val message: String?) : EmployeesUiState()
}