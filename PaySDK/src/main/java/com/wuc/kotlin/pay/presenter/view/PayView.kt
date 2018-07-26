package com.wuc.kotlin.pay.presenter.view

import com.wuc.kotlin.base.presenter.view.BaseView

/**
 * @author:     wuchao
 * @date:       2018/7/24 17:35
 * @desciption:  支付 视图回调
 */
interface PayView : BaseView {
    //获取支付签名
    fun onGetSignResult(result: String)

    //同步支付成功状态
    fun onPayOrderResult(result: Boolean)
}