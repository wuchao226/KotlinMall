package com.wuc.kotlin.message.provider

import android.content.Context
import cn.jpush.android.api.JPushInterface
import com.alibaba.android.arouter.facade.annotation.Route
import com.wuc.kotlin.provider.PushProvider
import com.wuc.kotlin.provider.router.RouterPath

/**
 * @author:     wuchao
 * @date:       2018/7/25 18:12
 * @desciption: 模块间接口调用  提供PushId的实现
 */
@Route(path = RouterPath.MessageCenter.PATH_MESSAGE_PUSH)
class PushProviderImpl : PushProvider {

    private var mContext: Context? = null

    override fun init(context: Context?) {
        mContext = context
    }

    override fun getPushId(): String {
        return JPushInterface.getRegistrationID(mContext)
    }

}