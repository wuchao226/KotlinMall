package com.wuc.kotlin.message.injection.component


import com.wuc.kotlin.base.injection.PerComponentScope
import com.wuc.kotlin.base.injection.component.ActivityComponent
import com.wuc.kotlin.message.injection.module.MessageModule
import com.wuc.kotlin.message.ui.fragment.MessageFragment
import dagger.Component

/*
    消息模块注入组件
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)],
        modules = [(MessageModule::class)])
interface MessageComponent {
    fun inject(fragment: MessageFragment)
}
