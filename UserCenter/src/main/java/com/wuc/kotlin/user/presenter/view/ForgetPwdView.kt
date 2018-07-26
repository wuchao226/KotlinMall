package com.wuc.kotlin.user.presenter.view

import com.wuc.kotlin.base.presenter.view.BaseView

/**
 * @author:     wuchao
 * @date:       2018/6/29 11:46
 * @desciption: 忘记密码 视图回调
 */
interface ForgetPwdView : BaseView {
    /*
    忘记密码回调
     */
    fun onForgetPwdResult(result: String)
}