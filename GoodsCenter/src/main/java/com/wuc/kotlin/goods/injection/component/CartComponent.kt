package com.wuc.kotlin.goods.injection.component

import com.wuc.kotlin.base.injection.PerComponentScope
import com.wuc.kotlin.base.injection.component.ActivityComponent
import com.wuc.kotlin.goods.injection.module.CartModule
import com.wuc.kotlin.goods.ui.fragment.CartFragment
import dagger.Component

/**
 * @author:     wuchao
 * @date:       2018/7/13 16:23
 * @desciption: 购物车 Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),
        modules = arrayOf(CartModule::class))
interface CartComponent {
    fun inject(fragment: CartFragment)
}