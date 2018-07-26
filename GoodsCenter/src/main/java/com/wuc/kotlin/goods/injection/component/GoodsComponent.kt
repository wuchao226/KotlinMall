package com.wuc.kotlin.goods.injection.component

import com.wuc.kotlin.base.injection.PerComponentScope
import com.wuc.kotlin.base.injection.component.ActivityComponent
import com.wuc.kotlin.goods.injection.module.CartModule
import com.wuc.kotlin.goods.injection.module.GoodsModule
import com.wuc.kotlin.goods.ui.activity.GoodsActivity
import com.wuc.kotlin.goods.ui.fragment.GoodsDetailTabOneFragment
import dagger.Component

/**
 * @author:     wuchao
 * @date:       2018/7/9 14:15
 * @desciption:
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),
        modules = arrayOf(GoodsModule::class, CartModule::class))
interface GoodsComponent {
    fun inject(activity: GoodsActivity)
    fun inject(fragment: GoodsDetailTabOneFragment)
}