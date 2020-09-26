package ru.modelov.testapp65apps.detailemployee.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.modelov.testapp65apps.main.domain.entities.Employee
import ru.modelov.testapp65apps.main.presentation.EventsDispatcher
import ru.modelov.testapp65apps.main.presentation.EventsDispatcherOwner

class DetailEmployeeViewModel(
    val employee: Employee
) : ViewModel(), EventsDispatcherOwner<DetailEmployeeViewModel.EventListener> {

    interface EventListener

    private val _employeeLiveData = MutableLiveData<Employee>()
    val employeeLiveData: LiveData<Employee>
        get() = _employeeLiveData

    override val eventsDispatcher: EventsDispatcher<EventListener> = EventsDispatcher()

    init {
        _employeeLiveData.value = employee
    }
}