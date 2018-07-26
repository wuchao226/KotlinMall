package com.wuc.kotlin.pay.data.api

import com.wuc.kotlin.base.data.protocol.BaseResp
import com.wuc.kotlin.pay.data.protocol.GetPaySignReq
import com.wuc.kotlin.pay.data.protocol.PayOrderReq
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * @author:     wuchao
 * @date:       2018/7/24 15:46
 * @desciption: 支付 接口
 */
interface PayApi {
    /*
       获取支付宝支付签名
     */
    @POST("pay/getPaySign")
    fun getPaySign(@Body req: GetPaySignReq): Observable<BaseResp<String>>

    /*
       刷新订单状态，已支付
    */
    @POST("order/pay")
    fun payOrder(@Body req: PayOrderReq): Observable<BaseResp<String>>
}