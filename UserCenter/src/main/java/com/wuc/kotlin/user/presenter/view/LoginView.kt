package com.wuc.kotlin.user.presenter.view

import com.wuc.kotlin.base.presenter.view.BaseView
import com.wuc.kotlin.user.data.protocol.UserInfo

/**
 * @author:     wuchao
 * @date:       2018/6/28 15:33
 * @desciption: 用户登录 视图回调
 */
interface LoginView : BaseView {
    fun onLoginResult(result: UserInfo)
}