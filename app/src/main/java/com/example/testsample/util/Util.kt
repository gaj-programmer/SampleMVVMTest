package com.example.testsample.util

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build

/**
 * Project           : SampleMVVM
 * File Name         : Util
 * Description       :
 * Revision History  : version 1
 * Date              : 14/07/21
 * Original author   : Gajraj
 */
object Util {

    @SuppressLint("InlinedApi")
    fun hasNetwork(context: Context): Boolean {
        var networkCapabilities: NetworkCapabilities? = null

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetwork
            if (netInfo != null) {
                networkCapabilities = cm.getNetworkCapabilities(cm.activeNetwork)
            }
            return networkCapabilities != null
                    && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) && networkCapabilities.hasCapability(
                NetworkCapabilities.NET_CAPABILITY_VALIDATED
            );
        } else {
            val connectivity =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networks: Array<Network> = connectivity.allNetworks
            var i = 0
            while (i < networks.size && networkCapabilities == null) {
                networkCapabilities = connectivity.getNetworkCapabilities(networks[i])
                i++
            }
            return networkCapabilities != null
                    && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) && networkCapabilities.hasCapability(
                NetworkCapabilities.NET_CAPABILITY_VALIDATED
            );
        }
    }
}