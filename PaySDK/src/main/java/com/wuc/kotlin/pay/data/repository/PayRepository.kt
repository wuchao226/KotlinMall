package com.wuc.kotlin.pay.data.repository

import com.wuc.kotlin.base.data.net.RetrofitFactory
import com.wuc.kotlin.base.data.protocol.BaseResp
import com.wuc.kotlin.pay.data.api.PayApi
import com.wuc.kotlin.pay.data.protocol.GetPaySignReq
import com.wuc.kotlin.pay.data.protocol.PayOrderReq
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/7/24 16:14
 * @desciption: 支付数据层
 */
class PayRepository @Inject constructor() {
    /*
        获取支付宝支付签名
     */
    fun getPaySign(orderId: Int, totalPrice: Long): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(PayApi::class.java)
                .getPaySign(GetPaySignReq(orderId, totalPrice))
    }

    /*
        刷新订单状态已支付
     */
    fun payOrder(orderId: Int): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(PayApi::class.java)
                .payOrder(PayOrderReq(orderId))
    }
}