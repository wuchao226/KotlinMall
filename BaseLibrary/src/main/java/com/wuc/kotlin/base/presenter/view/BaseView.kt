package com.wuc.kotlin.base.presenter.view

/**
 * @author:     wuchao
 * @date:       2018/6/21 14:43
 * @desciption: MVP 中视图回调 基类
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(error: String)
}