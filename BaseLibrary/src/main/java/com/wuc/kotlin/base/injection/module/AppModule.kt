package com.wuc.kotlin.base.injection.module

import android.content.Context
import com.wuc.kotlin.base.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author:     wuchao
 * @date:       2018/6/22 17:39
 * @desciption: Application级别Module
 */
@Module
class AppModule(private val context: BaseApplication) {
    @Singleton
    @Provides
    fun provideContext(): Context {
        return this.context
    }
}