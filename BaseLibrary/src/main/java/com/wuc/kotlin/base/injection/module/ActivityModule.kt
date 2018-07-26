package com.wuc.kotlin.base.injection.module

import android.app.Activity
import com.wuc.kotlin.base.injection.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * @author:     wuchao
 * @date:       2018/6/22 17:39
 * @desciption: Activity级别Module
 */
@Module
class ActivityModule(private val activity: Activity) {
    @Provides
    @ActivityScope
    fun provideActivity(): Activity {
        return this.activity
    }
}