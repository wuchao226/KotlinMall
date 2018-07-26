package com.wuc.kotlin.order.data.api

import com.wuc.kotlin.base.data.protocol.BaseResp
import com.wuc.kotlin.order.data.protocol.AddShipAddressReq
import com.wuc.kotlin.order.data.protocol.DeleteShipAddressReq
import com.wuc.kotlin.order.data.protocol.EditShipAddressReq
import com.wuc.kotlin.order.data.protocol.ShipAddress
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST


/*
    地址管理 接口
 */
interface ShipAddressApi {

    /*
        添加收货地址
     */
    @POST("shipAddress/add")
    fun addShipAddress(@Body req: AddShipAddressReq): Observable<BaseResp<String>>

    /*
        删除收货地址
     */
    @POST("shipAddress/delete")
    fun deleteShipAddress(@Body req: DeleteShipAddressReq): Observable<BaseResp<String>>

    /*
        修改收货地址
     */
    @POST("shipAddress/modify")
    fun editShipAddress(@Body req: EditShipAddressReq): Observable<BaseResp<String>>

    /*
        查询收货地址列表
     */
    @POST("shipAddress/getList")
    fun getShipAddressList(): Observable<BaseResp<MutableList<ShipAddress>?>>

}
