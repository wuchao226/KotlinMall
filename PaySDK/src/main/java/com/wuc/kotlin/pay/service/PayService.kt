package com.wuc.kotlin.pay.service

import io.reactivex.Observable

/**
 * @author:     wuchao
 * @date:       2018/7/24 16:17
 * @desciption: 支付业务接口
 */
interface PayService {

    /*
        获取支付宝支付签名
    */
    fun getPaySign(orderId: Int, totalPrice: Long): Observable<String>

    /*
        刷新订单状态已支付
    */
    fun payOrder(orderId: Int): Observable<Boolean>
}