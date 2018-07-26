package com.wuc.kotlin.user.injection.component

import com.wuc.kotlin.base.injection.PerComponentScope
import com.wuc.kotlin.base.injection.component.ActivityComponent
import com.wuc.kotlin.user.injection.module.UploadModule
import com.wuc.kotlin.user.injection.module.UserModule
import com.wuc.kotlin.user.ui.activity.*
import dagger.Component

/**
 * @author:     wuchao
 * @date:       2018/6/22 17:14
 * @desciption: 用户模块Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),
        modules = arrayOf(UserModule::class, UploadModule::class))
interface UserComponent {
    fun inject(activity: RegisterActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: ForgetPwdActivity)
    fun inject(activity: ResetPwdActivity)
    fun inject(activity: UserInfoActivity)
}