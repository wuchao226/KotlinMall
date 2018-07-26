package com.wuc.kotlin.order.presenter.view

import com.wuc.kotlin.base.presenter.view.BaseView
import com.wuc.kotlin.order.data.protocol.Order

/*
    订单详情页 视图回调
 */
interface OrderDetailView : BaseView {

    fun onGetOrderByIdResult(result: Order)
}
