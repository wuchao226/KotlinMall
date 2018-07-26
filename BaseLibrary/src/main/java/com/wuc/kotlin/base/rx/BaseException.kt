package com.wuc.kotlin.base.rx

/**
 * @author:     wuchao
 * @date:       2018/6/22 13:04
 * @desciption: 定义通用异常
 */
class BaseException(val status: Int, val msg: String) : Throwable() {
}