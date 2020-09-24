package ru.modelov.testapp65apps.main.presentation

interface EventsDispatcherOwner<T> {
    val eventsDispatcher: EventsDispatcher<T>
}