package com.wuc.kotlin.base.utils

import android.content.Context
import android.net.ConnectivityManager

/**
 * @author:     wuchao
 * @date:       2018/6/27 00:15
 * @desciption: 网络工具
 */
object NetWorkUtils {
    /**
     * 判断网络是否可用
     */
    fun isNetWorkAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    /**
     * 检测WiFi是否连接
     */
    fun isWifiConnected(context: Context): Boolean {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = manager.activeNetworkInfo
        return networkInfo != null && networkInfo.type == ConnectivityManager.TYPE_WIFI
    }

    /**
     * 检测3G是否连接
     */
    fun is3GConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.type == ConnectivityManager.TYPE_MOBILE
    }
}