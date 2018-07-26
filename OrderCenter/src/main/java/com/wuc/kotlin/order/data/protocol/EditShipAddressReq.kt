package com.wuc.kotlin.order.data.protocol

/*
    修改收货地址
 */
data class EditShipAddressReq(
        val id: Int,
        val shipUserName: String,
        val shipUserMobile: String,
        val shipAddress: String,
        val shipIsDefault: Int)
