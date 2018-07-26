package com.wuc.kotlin.order.presenter

import com.wuc.kotlin.base.ext.execute
import com.wuc.kotlin.base.presenter.BasePresenter
import com.wuc.kotlin.base.rx.BaseObserver
import com.wuc.kotlin.order.data.protocol.Order
import com.wuc.kotlin.order.presenter.view.OrderConfirmView
import com.wuc.kotlin.order.service.OrderService
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/7/17 17:18
 * @desciption: 订单确认
 */
class OrderConfirmPresenter @Inject constructor() : BasePresenter<OrderConfirmView>() {

    @Inject
    lateinit var orderService: OrderService

    /*
        根据ID获取订单
     */
    fun getOrderById(orderId: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        orderService.getOrderById(orderId)
                .execute(object : BaseObserver<Order>(mView) {
                    override fun onNext(t: Order) {
                        super.onNext(t)
                        mView.onGetOrderByIdResult(t)
                    }
                }, lifecycleProvider)
    }

    /*
        提交订单
     */
    fun submitOrder(order: Order) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        orderService.submitOrder(order)
                .execute(object : BaseObserver<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        super.onNext(t)
                        mView.onSubmitOrderResult(t)
                    }
                }, lifecycleProvider)
    }
}