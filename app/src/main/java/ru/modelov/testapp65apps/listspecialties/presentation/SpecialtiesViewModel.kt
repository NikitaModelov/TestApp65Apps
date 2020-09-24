package ru.modelov.testapp65apps.listspecialties.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import ru.modelov.testapp65apps.listspecialties.domain.repository.SpecialtiesRepository
import ru.modelov.testapp65apps.main.network.Result

class SpecialtiesViewModel(private val rep: SpecialtiesRepository) : ViewModel(), KoinComponent {

    fun getSpecialties() {
        viewModelScope.launch {
            when (val response = rep.getSpecialties()) {
                is Result.Success -> {
                    Log.d("VM", "${response.data}")
                }
                is Result.Error -> {
                    Log.d("VM", "${response.exception}")
                }
            }
        }
    }
}