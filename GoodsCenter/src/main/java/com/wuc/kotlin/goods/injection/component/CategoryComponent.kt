package com.wuc.kotlin.goods.injection.component

import com.wuc.kotlin.base.injection.PerComponentScope
import com.wuc.kotlin.base.injection.component.ActivityComponent
import com.wuc.kotlin.goods.injection.module.CategoryModule
import com.wuc.kotlin.goods.ui.fragment.CategoryFragment
import dagger.Component

/**
 * @author:     wuchao
 * @date:       2018/7/5 11:51
 * @desciption: 商品分类Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),
        modules = arrayOf(CategoryModule::class))
interface CategoryComponent {
    fun inject(fragment: CategoryFragment)
}