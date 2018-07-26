package com.wuc.kotlin.order.injection.module

import com.wuc.kotlin.order.service.OrderService
import com.wuc.kotlin.order.service.impl.OrderServiceImpl
import dagger.Module
import dagger.Provides

/**
 * @author:     wuchao
 * @date:       2018/7/17 17:44
 * @desciption: 订单Module
 */
@Module
class OrderModule {

    @Provides
    fun provider(orderService: OrderServiceImpl): OrderService {
        return orderService
    }
}