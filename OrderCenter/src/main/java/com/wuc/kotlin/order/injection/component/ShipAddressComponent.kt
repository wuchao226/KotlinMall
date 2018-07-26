package com.wuc.kotlin.order.injection.component

import com.wuc.kotlin.base.injection.PerComponentScope
import com.wuc.kotlin.base.injection.component.ActivityComponent
import com.wuc.kotlin.order.injection.module.ShipAddressModule
import com.wuc.kotlin.order.ui.activity.ShipAddressActivity
import com.wuc.kotlin.order.ui.activity.ShipAddressEditActivity
import dagger.Component

/**
 * @author:     wuchao
 * @date:       2018/7/18 17:31
 * @desciption: 收货人信息Component
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)],
        modules = [(ShipAddressModule::class)])
interface ShipAddressComponent {
    fun inject(activity: ShipAddressActivity)
    fun inject(activity: ShipAddressEditActivity)
}