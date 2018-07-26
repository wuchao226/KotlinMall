package com.wuc.kotlin.order.injection.component

import com.wuc.kotlin.base.injection.PerComponentScope
import com.wuc.kotlin.base.injection.component.ActivityComponent
import com.wuc.kotlin.order.injection.module.OrderModule
import com.wuc.kotlin.order.ui.activity.OrderConfirmActivity
import com.wuc.kotlin.order.ui.activity.OrderDetailActivity
import com.wuc.kotlin.order.ui.fragment.OrderFragment
import dagger.Component

/**
 * @author:     wuchao
 * @date:       2018/7/17 17:46
 * @desciption: 订单Component
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)],
        modules = [(OrderModule::class)])
interface OrderComponent {
    fun inject(activity: OrderConfirmActivity)
    fun inject(fragment: OrderFragment)
    fun inject(activity: OrderDetailActivity)
}