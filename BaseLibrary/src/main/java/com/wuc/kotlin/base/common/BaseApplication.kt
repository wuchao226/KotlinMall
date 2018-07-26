package com.wuc.kotlin.base.common

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.wuc.kotlin.base.injection.component.AppComponent
import com.wuc.kotlin.base.injection.component.DaggerAppComponent
import com.wuc.kotlin.base.injection.module.AppModule
import kotlin.properties.Delegates

/**
 * @author:     wuchao
 * @date:       2018/6/22 17:46
 * @desciption: Application基类
 */
open class BaseApplication : Application() {

    lateinit var mAppComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        context = this
        initAppInjection()

        // 打印日志
        ARouter.openLog()
        // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.openDebug()
        ARouter.init(this)
    }

    private fun initAppInjection() {
        mAppComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    /**
     * 全局伴生对象
     */
    companion object {
        var context: BaseApplication by Delegates.notNull()
    }
}