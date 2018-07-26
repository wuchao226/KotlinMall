package com.wuc.kotlin.pay.injection.module

import com.wuc.kotlin.pay.service.PayService
import com.wuc.kotlin.pay.service.impl.PayServiceImpl
import dagger.Module
import dagger.Provides

/**
 * @author:     wuchao
 * @date:       2018/7/24 17:11
 * @desciption: 支付 Module
 */
@Module
class PayModule {

    @Provides
    fun providerPayService(payService: PayServiceImpl): PayService {
        return payService
    }
}