package ru.modelov.testapp65apps.main.presentation

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import java.util.*

class EventsDispatcher<L> : LifecycleObserver {

    private var eventsListener: L? = null
    private var boundListener: L? = null
    private val blocks = LinkedList<L.() -> Unit>()

    fun bind(lifecycleOwner: LifecycleOwner, listener: L) {
        eventsListener = listener
        lifecycleOwner.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun connectListener() {
        boundListener = eventsListener
        val listener = boundListener ?: return
        blocks.forEach {
            it(listener)
        }
        blocks.clear()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun disconnectListener() {
        boundListener = null
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun clear(source: LifecycleOwner) {
        eventsListener = null
        boundListener = null
        source.lifecycle.removeObserver(this)
    }

    fun dispatchEvent(block: L.() -> Unit) {
        boundListener?.also(block) ?: blocks.add(block)
    }
}