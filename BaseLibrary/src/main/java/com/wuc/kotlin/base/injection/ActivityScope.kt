package com.wuc.kotlin.base.injection

import javax.inject.Scope

/**
 * @author:     wuchao
 * @date:       2018/6/22 17:57
 * @desciption: Activity级别 作用域
 */
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope