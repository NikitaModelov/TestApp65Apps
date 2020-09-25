package ru.modelov.testapp65apps.main.network.di

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import ru.modelov.testapp65apps.main.network.InternetCheck
import ru.modelov.testapp65apps.main.network.NoConnectivityException

private const val baseUrl = "http://gitlab.65apps.com/65gb/static/raw/master/"

private val networkModule = module {
    single { noConnectionInterceptor(androidContext()) }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

private fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()


inline fun <reified T> createRetrofitService(retrofit: Retrofit): T =
    retrofit.create(T::class.java)

internal fun noConnectionInterceptor(context: Context) = Interceptor { chain ->
    val checker = InternetCheck(context)
    return@Interceptor if (checker.isConnectionOff) {
        throw NoConnectivityException()
    } else {
        chain.proceed(chain.request())
    }
}

val NetworkModules = listOf(
    networkModule
)