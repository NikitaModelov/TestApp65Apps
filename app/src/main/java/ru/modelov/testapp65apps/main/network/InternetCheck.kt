package ru.modelov.testapp65apps.main.network

import android.annotation.TargetApi
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import java.io.IOException

class NoConnectivityException : IOException()

class InternetCheck(context: Context) {

    private val cm =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val isConnectionOff: Boolean
        get() = !isConnectionOn()

    private fun isConnectionOn(): Boolean =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            postAndroidMInternetCheck()
        } else {
            preAndroidMInternetCheck()
        }

    @TargetApi(Build.VERSION_CODES.M)
    private fun postAndroidMInternetCheck(): Boolean =
        cm.getNetworkCapabilities(cm.activeNetwork)?.let {
            it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || it.hasTransport(
                NetworkCapabilities.TRANSPORT_CELLULAR
            )
        } ?: false

    @Suppress("DEPRECATION")
    private fun preAndroidMInternetCheck(): Boolean =
        cm.activeNetworkInfo?.let {
            it.type == ConnectivityManager.TYPE_WIFI || it.type == ConnectivityManager.TYPE_MOBILE
        } ?: false
}