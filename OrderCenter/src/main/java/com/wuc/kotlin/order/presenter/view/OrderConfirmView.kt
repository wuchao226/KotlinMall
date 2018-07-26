package com.wuc.kotlin.order.presenter.view

import com.wuc.kotlin.base.presenter.view.BaseView
import com.wuc.kotlin.order.data.protocol.Order

/**
 * @author:     wuchao
 * @date:       2018/7/17 17:19
 * @desciption: 订单确认页视图回调
 */
interface OrderConfirmView : BaseView {

    //获取订单回调
    fun onGetOrderByIdResult(result: Order)

    //提交订单回调
    fun onSubmitOrderResult(result: Boolean)
}