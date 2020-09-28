package ru.modelov.testapp65apps.feature.employee.listemployees.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.modelov.testapp65apps.feature.employee.listemployees.domain.usecase.GetEmployeesUseCase
import ru.modelov.testapp65apps.feature.employee.listemployees.presentation.uistate.EmployeesUiState
import ru.modelov.testapp65apps.main.domain.entities.Employee
import ru.modelov.testapp65apps.main.domain.entities.Employees
import ru.modelov.testapp65apps.main.network.Result
import ru.modelov.testapp65apps.main.presentation.EventsDispatcher
import ru.modelov.testapp65apps.main.presentation.EventsDispatcherOwner

class EmployeesViewModel(
    val idSpecialty: Long,
    private val getEmployeesUseCase: GetEmployeesUseCase
) : ViewModel(), EventsDispatcherOwner<EmployeesViewModel.EventsListener> {

    interface EventsListener {
        fun navigateToDetailEmployee(employee: Employee)
        fun navigateToBack()
    }

    override val eventsDispatcher: EventsDispatcher<EventsListener> = EventsDispatcher()

    private val _uiStateLiveData = MutableLiveData<EmployeesUiState>(EmployeesUiState.Loading)
    val uiStateLiveData: LiveData<EmployeesUiState>
        get() = _uiStateLiveData

    private val _employeesLiveData = MutableLiveData<Employees>()
    val employeesLiveData: LiveData<Employees>
        get() = _employeesLiveData

    init {
        getEmployees(idSpecialty)
    }

    fun onClickEmployee(employee: Employee) {
        eventsDispatcher.dispatchEvent { navigateToDetailEmployee(employee) }
    }

    fun refreshData() {
        getEmployees(idSpecialty)
    }

    fun navigateToBack() {
        eventsDispatcher.dispatchEvent { navigateToBack() }
    }

    private fun getEmployees(id: Long) {
        viewModelScope.launch {
            when (val response = getEmployeesUseCase(id)) {
                is Result.Success -> {
                    _employeesLiveData.value = response.data
                    _uiStateLiveData.value = EmployeesUiState.Success
                }
                is Result.Error -> {
                    _uiStateLiveData.value = EmployeesUiState.Error(response.exception.toString())
                }
            }
        }
    }
}