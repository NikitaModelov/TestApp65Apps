package ru.modelov.testapp65apps.listemployees.presentation

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import ru.modelov.testapp65apps.listemployees.domain.usecase.GetEmployeesUseCase
import ru.modelov.testapp65apps.main.entities.Employees
import ru.modelov.testapp65apps.main.network.Result
import ru.modelov.testapp65apps.main.presentation.EventsDispatcher
import ru.modelov.testapp65apps.main.presentation.EventsDispatcherOwner

class EmployeesViewModel(
    val idSpecialty: Long,
    private val getEmployeesUseCase: GetEmployeesUseCase
) : ViewModel(), EventsDispatcherOwner<EmployeesViewModel.EventsListener>, LifecycleObserver,
    KoinComponent {

    interface EventsListener

    override val eventsDispatcher: EventsDispatcher<EventsListener> = EventsDispatcher()

    private val _employeesLiveData = MutableLiveData<Employees>()
    val employeesLiveData: LiveData<Employees>
        get() = _employeesLiveData

    private val _test = MutableLiveData<String>()
    val test: LiveData<String>
        get() = _test

    init {
        _test.value = idSpecialty.toString()
        //getEmployees(idSpecialty)
    }

    private fun getEmployees(id: Long) {
        viewModelScope.launch {
            when (val response = getEmployeesUseCase(id)) {
                is Result.Success -> {
                    _employeesLiveData.value = response.data
                    Log.d("VME", "${response.data}")
                }
                is Result.Error -> {
                    Log.d("VM", "${response.exception}")
                }
            }
        }
    }
}