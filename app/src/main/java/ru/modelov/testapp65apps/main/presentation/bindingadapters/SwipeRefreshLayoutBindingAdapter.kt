package ru.modelov.testapp65apps.main.presentation.bindingadapters

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

@BindingAdapter("onRefresh")
fun SwipeRefreshLayout.onRefresh(listener: () -> Unit) {
    setOnRefreshListener {
        listener.invoke()
        isRefreshing = false
    }
}