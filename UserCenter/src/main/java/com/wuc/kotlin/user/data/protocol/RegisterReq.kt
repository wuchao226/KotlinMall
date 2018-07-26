package com.wuc.kotlin.user.data.protocol

/**
 * @author:     wuchao
 * @date:       2018/6/22 13:09
 * @desciption: 注册请求体
 */
class RegisterReq(val mobile: String, val pwd: String, val verifyCode: String)