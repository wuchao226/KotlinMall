package com.wuc.kotlin.order.injection.module

import com.wuc.kotlin.order.service.ShipAddressService
import com.wuc.kotlin.order.service.impl.ShipAddressServiceImpl
import dagger.Module
import dagger.Provides

/**
 * @author:     wuchao
 * @date:       2018/7/18 17:29
 * @desciption: 收货信息Module
 */
@Module
class ShipAddressModule {

    @Provides
    fun provideShipAddressService(shipAddressService: ShipAddressServiceImpl):ShipAddressService{
        return shipAddressService
    }
}