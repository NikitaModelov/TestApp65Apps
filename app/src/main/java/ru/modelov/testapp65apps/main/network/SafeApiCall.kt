package ru.modelov.testapp65apps.main.network

import retrofit2.Response
import java.io.IOException

suspend fun <T : Any> safeApiCall(
    call: suspend () -> Response<T>
): Result<T> {
    try {
        val response = call.invoke()
        if (response.isSuccessful) return Result.Success(response.body()!!)
        return Result.Error(IOException("Error Occurred during getting safe Api result, Custom ERROR - ${response.errorBody()}"))
    } catch (ex: IOException) {
        return Result.Error(ex)
    }
}

suspend fun <T : Any> safeDatabaseCall(
    query: suspend () -> T
): Result<T> {
    return try {
        val response = query.invoke()
        Result.Success(response)
    } catch (ex: Exception) {
        Result.Error(ex)
    }
}
