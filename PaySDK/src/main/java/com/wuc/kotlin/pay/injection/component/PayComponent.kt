package com.wuc.kotlin.pay.injection.component

import com.wuc.kotlin.base.injection.PerComponentScope
import com.wuc.kotlin.base.injection.component.ActivityComponent
import com.wuc.kotlin.pay.injection.module.PayModule
import com.wuc.kotlin.pay.ui.activity.CashRegisterActivity
import dagger.Component

/**
 * @author:     wuchao
 * @date:       2018/7/24 17:13
 * @desciption: 支付Component
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)]
        , modules = [(PayModule::class)])
interface PayComponent {
    fun inject(activity: CashRegisterActivity)
}