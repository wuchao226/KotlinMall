package com.wuc.kotlin.base.injection.component

import android.app.Activity
import android.content.Context
import com.trello.rxlifecycle2.LifecycleProvider
import com.wuc.kotlin.base.injection.ActivityScope
import com.wuc.kotlin.base.injection.module.ActivityModule
import com.wuc.kotlin.base.injection.module.LifecycleProviderModule
import dagger.Component

/**
 * @author:     wuchao
 * @date:       2018/6/22 17:41
 * @desciption: Activity级别Component
 */
@ActivityScope
@Component(dependencies = [(AppComponent::class)],
        modules = [(ActivityModule::class), (LifecycleProviderModule::class)])
interface ActivityComponent {
    fun activity(): Activity
    fun context(): Context
    fun lifecycleProvider(): LifecycleProvider<*>
}