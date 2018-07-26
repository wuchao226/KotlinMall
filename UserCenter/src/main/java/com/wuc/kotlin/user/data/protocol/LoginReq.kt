package com.wuc.kotlin.user.data.protocol

/**
 * @author:     wuchao
 * @date:       2018/6/22 13:09
 * @desciption: 登录请求体
 */
class LoginReq(val mobile: String, val pwd: String, val pushId: String)