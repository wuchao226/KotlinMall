package com.wuc.kotlin.pay.service.impl

import com.wuc.kotlin.base.ext.convert
import com.wuc.kotlin.base.ext.convertBoolean
import com.wuc.kotlin.pay.data.repository.PayRepository
import com.wuc.kotlin.pay.service.PayService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author:     wuchao
 * @date:       2018/7/24 16:25
 * @desciption:     支付 业务实现类

 */
class PayServiceImpl @Inject constructor() : PayService {
    @Inject
    lateinit var repository: PayRepository

    /*
        获取支付签名
     */
    override fun getPaySign(orderId: Int, totalPrice: Long): Observable<String> {
        return repository.getPaySign(orderId, totalPrice).convert()
    }

    /*
       支付订单，同步订单状态
     */
    override fun payOrder(orderId: Int): Observable<Boolean> {
        return repository.payOrder(orderId).convertBoolean()
    }
}