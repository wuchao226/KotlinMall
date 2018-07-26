package com.wuc.kotlin.provider

import com.alibaba.android.arouter.facade.template.IProvider

/**
 * @author:     wuchao
 * @date:       2018/7/25 18:10
 * @desciption: 跨模块接口调用  接口定义
 */
interface PushProvider : IProvider {
    fun getPushId(): String
}