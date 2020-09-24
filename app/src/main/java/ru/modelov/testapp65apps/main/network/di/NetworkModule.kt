package ru.modelov.testapp65apps.main.network.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val baseUrl = "http://gitlab.65apps.com/65gb/static/raw/master/"

private val networkModule = module {
    single { provideOkHttpClient() }
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

private fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()


inline fun <reified T> createRetrofitService(retrofit: Retrofit): T =
    retrofit.create(T::class.java)

val NetworkModules = listOf(
    networkModule
)