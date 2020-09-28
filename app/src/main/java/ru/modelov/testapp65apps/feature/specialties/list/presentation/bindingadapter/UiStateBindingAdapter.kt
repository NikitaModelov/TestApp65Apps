package ru.modelov.testapp65apps.feature.specialties.list.presentation.bindingadapter

import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import ru.modelov.testapp65apps.feature.specialties.list.presentation.uistate.SpecialtiesUiState

@BindingAdapter("uiStateLoading")
fun FrameLayout.setUiState(state: SpecialtiesUiState) {
    visibility = when (state) {
        is SpecialtiesUiState.Success -> View.GONE
        is SpecialtiesUiState.Loading -> View.VISIBLE
        is SpecialtiesUiState.Error -> View.GONE
    }
}

@BindingAdapter("uiStateError")
fun LinearLayout.setUiStateError(state: SpecialtiesUiState) {
    visibility = when (state) {
        is SpecialtiesUiState.Success -> {
            View.GONE
        }
        is SpecialtiesUiState.Loading -> {
            View.GONE
        }
        is SpecialtiesUiState.Error -> {
            View.VISIBLE
        }
    }
}