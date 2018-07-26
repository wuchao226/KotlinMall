package com.wuc.kotlin.user.presenter.view

import com.wuc.kotlin.base.presenter.view.BaseView

/**
 * @author:     wuchao
 * @date:       2018/6/21 15:32
 * @desciption: 用户注册，视图回调
 */
interface RegisterView : BaseView {
    fun onRegisterResult(result: String)
}