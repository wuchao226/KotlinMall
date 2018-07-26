package com.wuc.kotlin.user.data.protocol

/**
 * @author:     wuchao
 * @date:       2018/6/29 14:01
 * @desciption: 忘记密码请求体
 */
class ForgetPwdReq(val mobile: String, val verifyCode: String)