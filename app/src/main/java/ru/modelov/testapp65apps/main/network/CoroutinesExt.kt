package ru.modelov.testapp65apps.main.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T : Any> myRun(work: suspend () -> T): ResultHandler<T> =
    withContext(Dispatchers.IO) {

            val result = work()
            withContext(Dispatchers.Main) {
                when (result) {
                    is Throwable -> ResultHandler.Error(result)
                    else -> ResultHandler.Success(result)
                }
            }

    }


sealed class ResultHandler<out T : Any> {
    data class Success<out T : Any>(val data: T) : ResultHandler<T>()
    data class Error(val throwable: Throwable) : ResultHandler<Nothing>()
}

