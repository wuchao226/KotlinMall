package com.wuc.kotlin.base.presenter

import android.content.Context
import com.trello.rxlifecycle2.LifecycleProvider
import com.wuc.kotlin.base.presenter.view.BaseView
import com.wuc.kotlin.base.utils.NetWorkUtils
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/6/21 14:43
 * @desciption: MVP中P层 基类
 */
open class BasePresenter<T : BaseView> {

    lateinit var mView: T
    /**
     * Dagger注入，Rx生命周期管理
     */
    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

    /**
     * 检查网络是否可用
     */
    fun checkNetWork(): Boolean {
        if (NetWorkUtils.isNetWorkAvailable(context)) {
            return true
        }
        mView.onError("网络不可用")
        return false
    }
}