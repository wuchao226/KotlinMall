package com.wuc.kotlin.order.service.impl

import com.wuc.kotlin.base.ext.convert
import com.wuc.kotlin.base.ext.convertBoolean
import com.wuc.kotlin.order.data.protocol.ShipAddress
import com.wuc.kotlin.order.data.repository.ShipAddressRepository
import com.wuc.kotlin.order.service.ShipAddressService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/7/18 17:16
 * @desciption: 收货人信息 业务实现类
 */
class ShipAddressServiceImpl @Inject constructor() : ShipAddressService {

    @Inject
    lateinit var repository: ShipAddressRepository

    /*
        添加收货地址
     */
    override fun addShipAddress(shipUserName: String, shipUserMobile: String, shipAddress: String):
            Observable<Boolean> {
        return repository.addShipAddress(shipUserName, shipUserMobile, shipAddress).convertBoolean()
    }

    /*
        删除收货地址
     */
    override fun deleteShipAddress(id: Int): Observable<Boolean> {
        return repository.deleteShipAddress(id).convertBoolean()
    }

    /*
        修改收货地址
     */
    override fun editShipAddress(address: ShipAddress): Observable<Boolean> {
        return repository.editShipAddress(address).convertBoolean()
    }

    /*
        获取收货地址列表
     */
    override fun getShipAddressList(): Observable<MutableList<ShipAddress>?> {
        return repository.getShipAddressList().convert()
    }
}