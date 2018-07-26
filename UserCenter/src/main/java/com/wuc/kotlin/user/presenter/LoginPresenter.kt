package com.wuc.kotlin.user.presenter

import com.wuc.kotlin.base.ext.execute
import com.wuc.kotlin.base.presenter.BasePresenter
import com.wuc.kotlin.base.rx.BaseObserver
import com.wuc.kotlin.user.data.protocol.UserInfo
import com.wuc.kotlin.user.presenter.view.LoginView
import com.wuc.kotlin.user.service.UserService
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/6/28 15:46
 * @desciption: 登录界面 Presenter
 */
class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {
    @Inject
    lateinit var userService: UserService

    fun login(mobile: String, pwd: String, pushId: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.login(mobile, pwd, pushId)
                .execute(object : BaseObserver<UserInfo>(mView) {
                    override fun onNext(t: UserInfo) {
                        super.onNext(t)
                        mView.onLoginResult(t)
                    }
                }, lifecycleProvider)
    }
}