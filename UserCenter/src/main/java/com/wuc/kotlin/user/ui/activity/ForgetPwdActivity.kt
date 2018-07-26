package com.wuc.kotlin.user.ui.activity

import android.os.Bundle
import android.view.View
import com.wuc.kotlin.base.ext.enable
import com.wuc.kotlin.base.ext.onClick
import com.wuc.kotlin.base.ui.activity.BaseMvpActivity
import com.wuc.kotlin.user.R
import com.wuc.kotlin.user.injection.component.DaggerUserComponent
import com.wuc.kotlin.user.presenter.ForgetPwdPresenter
import com.wuc.kotlin.user.presenter.view.ForgetPwdView
import kotlinx.android.synthetic.main.activity_forget_pwd.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * @author:     wuchao
 * @date:       2018/6/29 14:33
 * @desciption: 忘记密码界面
 */
class ForgetPwdActivity : BaseMvpActivity<ForgetPwdPresenter>(), ForgetPwdView, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pwd)
        initView()
    }

    /*
    初始化视图
     */
    private fun initView() {
        mNextBtn.enable(mMobileEt, { isBtnEnable() })
        mNextBtn.enable(mVerifyCodeEt, { isBtnEnable() })

        mVerifyCodeBtn.onClick(this)
        mNextBtn.onClick(this)
    }

    /*
     Dagger注册
     */
    override fun injectComponent() {
        DaggerUserComponent.builder()
                .activityComponent(mActivityComponent)
                .build()
                .inject(this)
        mPresenter.mView = this
    }

    /*
    忘记密码回调
     */
    override fun onForgetPwdResult(result: String) {
        toast(result)
        startActivity<ResetPwdActivity>(Pair("mobile", mMobileEt.text.toString()))
    }

    /*
    点击事件
     */
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.mVerifyCodeBtn -> {
                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("发送验证成功")
            }
            R.id.mNextBtn ->
                mPresenter.forgetPwd(mMobileEt.text.toString(), mVerifyCodeEt.text.toString())
        }
    }

    /*
    判断按钮是否可用
     */
    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not()
    }

}