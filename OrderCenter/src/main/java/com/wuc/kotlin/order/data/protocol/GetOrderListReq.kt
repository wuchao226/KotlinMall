package com.wuc.kotlin.order.data.protocol

/*
    根据订单状态查询查询订单列表
 */
data class GetOrderListReq(val orderStatus: Int)
