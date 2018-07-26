package com.wuc.kotlin.mall.ui.activity

import android.os.Bundle
import com.wuc.kotlin.base.ext.onClick
import com.wuc.kotlin.base.ui.activity.BaseActivity
import com.wuc.kotlin.mall.R
import com.wuc.kotlin.user.utils.UserPrefsUtils
import kotlinx.android.synthetic.main.activity_setting.*
import org.jetbrains.anko.toast

/**
 * @author:     wuchao
 * @date:       2018/7/4 17:19
 * @desciption: 设置界面
 */
class SettingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        mUserProtocolTv.onClick {
            toast("用户协议")
        }
        mFeedBackTv.onClick {
            toast("反馈意见")
        }
        mAboutTv.onClick {
            toast("关于")
        }

        //退出登录，清空本地用户数据
        mLogoutBtn.onClick {
            UserPrefsUtils.putUserInfo(null)
            finish()
        }
    }
}