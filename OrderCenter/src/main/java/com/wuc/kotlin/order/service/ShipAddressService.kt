package com.wuc.kotlin.order.service

import com.wuc.kotlin.order.data.protocol.ShipAddress
import io.reactivex.Observable

/**
 * @author:     wuchao
 * @date:       2018/7/18 16:58
 * @desciption: 收货地址 业务接口
 */
interface ShipAddressService {

    /*
        添加收货地址
     */
    fun addShipAddress(shipUserName: String, shipUserMobile: String, shipAddress: String): Observable<Boolean>

    /*
        删除收货地址
     */
    fun deleteShipAddress(id: Int): Observable<Boolean>

    /*
        修改收货地址
     */
    fun editShipAddress(address: ShipAddress): Observable<Boolean>

    /*
        获取收货地址列表
     */
    fun getShipAddressList(): Observable<MutableList<ShipAddress>?>
}