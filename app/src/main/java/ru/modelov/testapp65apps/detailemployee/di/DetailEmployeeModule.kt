package ru.modelov.testapp65apps.detailemployee.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.modelov.testapp65apps.detailemployee.presentation.DetailEmployeeViewModel
import ru.modelov.testapp65apps.main.domain.entities.Employee

private val viewModelModule = module {
    viewModel { (employee: Employee) ->
        DetailEmployeeViewModel(
            employee = employee
        )
    }
}

val DetailEmployeeModule = listOf(
    viewModelModule
)