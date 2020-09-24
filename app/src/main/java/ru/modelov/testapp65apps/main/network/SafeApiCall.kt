package ru.modelov.testapp65apps.main.network

import retrofit2.Response
import java.io.IOException

suspend fun <T : Any> safeApiCall(
    call: suspend () -> Response<T>
): Result<T> {
    val response = call.invoke()
    if (response.isSuccessful) return Result.Success(response.body()!!)

    return Result.Error(IOException("Error Occurred during getting safe Api result, Custom ERROR - ${response.errorBody()}"))
}
