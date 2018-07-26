package com.wuc.kotlin.base.common

/**
 * @author:     wuchao
 * @date:       2018/6/21 22:24
 * @desciption: 基础常量
 */
class BaseConstant {
    companion object {
        //七牛服务地址
        const val IMAGE_SERVER_ADDRESS = "http://osea2fxp7.bkt.clouddn.com/"
        //本地服务器地址
        //const val SERVER_ADDRESS = "192.168.4.70:8080"//192.168.1.100
        const val SERVER_ADDRESS = "http://192.168.4.70:8080/Kotlin_Server/"
        //SP表名
        const val TABLE_PREFS = "Kotlin_mall"
        //Token Key
        const val KEY_SP_TOKEN = "token"
    }
}