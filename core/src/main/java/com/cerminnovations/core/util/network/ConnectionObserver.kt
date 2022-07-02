package com.cerminnovations.core.util.network

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET
import android.os.Build
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.InetSocketAddress
import javax.inject.Inject
import javax.net.SocketFactory

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class ConnectionObserver @Inject constructor(
    @ApplicationContext context: Context
) {

    private val connManager = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

    @Suppress("DEPRECATION")
    suspend fun hasInternetConnection(): Boolean {
        return when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.M -> {
                val activeNetwork = connManager.activeNetwork ?: return false
                checkInternetState(activeNetwork)
            }
            else -> {
                val networkInfo = connManager.activeNetworkInfo ?: return false
                when {
                    networkInfo.isConnectedOrConnecting -> ValidateConnectivity.execute(
                        SocketFactory.getDefault()
                    )
                    else -> false
                }
            }
        }
    }

    private suspend fun checkInternetState(network: Network): Boolean {
        val networkCapabilities = connManager.getNetworkCapabilities(network) ?: return false
        val hasCapability = networkCapabilities.hasCapability(NET_CAPABILITY_INTERNET)

        return when {
            hasCapability -> {
                ValidateConnectivity.execute(network.socketFactory)
            }
            else -> false
        }
    }

    object ValidateConnectivity {
        suspend fun execute(socketFactory: SocketFactory): Boolean = withContext(Dispatchers.IO) {
            kotlin.runCatching {
                try {
                    val socket = socketFactory.createSocket() ?: throw IOException("Socket is null")
                    socket.connect(InetSocketAddress("8.8.8.8", 53), 1500)
                    socket.close()
                } catch (e: IOException) {
                    false
                }
            }.isSuccess
        }
    }
}
