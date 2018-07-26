package com.wuc.kotlin.mall.common

import cn.jpush.android.api.JPushInterface
import com.wuc.kotlin.base.common.BaseApplication

/**
 * @author:     wuchao
 * @date:       2018/7/25 16:55
 * @desciption: 主工程 Application
 */
class MainApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        //极光推送初始化
        JPushInterface.setDebugMode(true)
        JPushInterface.init(this)
    }
}