package com.wuc.kotlin.base.data.protocol

/**
 * @author:     wuchao
 * @date:       2018/6/22 11:53
 * @desciption:  能用响应对象
 * @status:响应状态码
 * @message:响应文字消息
 * @data:具体响应业务对象
 */
data class BaseResp<T>(val status: Int, val message: String, val data: T)