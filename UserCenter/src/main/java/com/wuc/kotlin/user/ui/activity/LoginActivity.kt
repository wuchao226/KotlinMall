package com.wuc.kotlin.user.ui.activity

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.wuc.kotlin.base.ext.enable
import com.wuc.kotlin.base.ext.onClick
import com.wuc.kotlin.base.ui.activity.BaseMvpActivity
import com.wuc.kotlin.provider.PushProvider
import com.wuc.kotlin.provider.router.RouterPath
import com.wuc.kotlin.user.R
import com.wuc.kotlin.user.data.protocol.UserInfo
import com.wuc.kotlin.user.injection.component.DaggerUserComponent
import com.wuc.kotlin.user.presenter.LoginPresenter
import com.wuc.kotlin.user.presenter.view.LoginView
import com.wuc.kotlin.user.utils.UserPrefsUtils
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * @author:     wuchao
 * @date:       2018/6/28 16:33
 * @desciption: 登录界面
 */
@Route(path = RouterPath.UserCenter.PATH_LOGIN)
class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener {

    @Autowired(name = RouterPath.MessageCenter.PATH_MESSAGE_PUSH)
    @JvmField
    var mPushProvider: PushProvider? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    /**
     * 初始化视图
     */
    private fun initView() {
        mLoginBtn.enable(mMobileEt) { isBtnEnable() }
        mLoginBtn.enable(mPwdEt) { isBtnEnable() }

        mLoginBtn.onClick(this)
        mForgetPwdTv.onClick(this)
        mHeaderBar.getRightView().onClick(this)
    }

    /**
     * Dagger注册
     */
    override fun injectComponent() {
        DaggerUserComponent.builder()
                .activityComponent(mActivityComponent)
                .build()
                .inject(this)
        mPresenter.mView = this
    }

    /**
     *  登录回调
     */
    override fun onLoginResult(result: UserInfo) {
        toast("登录成功")
        UserPrefsUtils.putUserInfo(result)
        finish()
    }

    /**
     * 点击事件
     */
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.mRightTv ->
                startActivity<RegisterActivity>()
            R.id.mLoginBtn ->
                mPresenter.login(mMobileEt.text.toString(), mPwdEt.text.toString(),
                        mPushProvider?.getPushId() ?: "")
            R.id.mForgetPwdTv -> {
                startActivity<ForgetPwdActivity>()
            }
        }
    }

    /**
     * 判断按钮是否可用
     */
    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }
}